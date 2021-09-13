package polsl.stream.join.data.algorithm;

import org.jetbrains.annotations.NotNull;
import polsl.stream.join.data.model.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamJoin implements Join {

    private final Config config;

    private String joinMethodName;

    private List<String> firstFieldNames;

    private List<String> secondFieldNames;

    private static @NotNull List<String> getFieldNamesForClass(@NotNull Class<?> clazz) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> fieldNames.add(field.getName()));
        return fieldNames;
    }

    private @NotNull Boolean checkJoinColumn() {
        return this.firstFieldNames.stream().anyMatch(field -> Objects.equals(field, config.getJoinColumn())) &&
               this.secondFieldNames.stream().anyMatch(field -> Objects.equals(field, config.getJoinColumn()));
    }

    private void getFieldNames() {
        switch (config.getFirstFile()) {
            case "1_CarData.csv" -> this.firstFieldNames = getFieldNamesForClass(CarData.class);
            case "1_CarData_Sales.csv" -> this.firstFieldNames = getFieldNamesForClass(CarDataSales.class);
            case "2_Food_Choices.csv" -> this.firstFieldNames = getFieldNamesForClass(FoodChoices.class);
            case "2_Food_Preference.csv" -> this.firstFieldNames = getFieldNamesForClass(FoodPreference.class);
            case "3_Korea_Income_and_Welfare.csv" -> this.firstFieldNames = getFieldNamesForClass(KoreaIncome.class);
            case "3_Test_Income" -> this.firstFieldNames = getFieldNamesForClass(TestIncome.class);
            default -> this.firstFieldNames = null;
        }
        switch (config.getSecondFile()) {
            case "1_CarData.csv" -> this.secondFieldNames = getFieldNamesForClass(CarData.class);
            case "1_CarData_Sales.csv" -> this.secondFieldNames = getFieldNamesForClass(CarDataSales.class);
            case "2_Food_Choices.csv" -> this.secondFieldNames = getFieldNamesForClass(FoodChoices.class);
            case "2_Food_Preference.csv" -> this.secondFieldNames = getFieldNamesForClass(FoodPreference.class);
            case "3_Korea_Income_and_Welfare.csv" -> this.secondFieldNames = getFieldNamesForClass(KoreaIncome.class);
            case "3_Test_Income" -> this.secondFieldNames = getFieldNamesForClass(TestIncome.class);
            default -> this.secondFieldNames = null;
        }
    }

    public StreamJoin(Config config) {
        this.config = config;
    }

    @Override
    public List<String> innerJoin(StreamModels firstStream, StreamModels secondStream) {
        this.getFieldNames();
        if (Boolean.FALSE.equals(this.checkJoinColumn())) {
            System.out.println("ERROR");
            return null;
        }
        this.joinMethodName = "get" + (config.getJoinColumn().substring(0, 1).toUpperCase() + config.getJoinColumn().substring(1));
        List<String> returnedStream = new ArrayList<>();
        firstStream.findActiveStream().forEach(firstStreamData -> {
            try {
                var firstDataStreamField = Class.forName(firstStreamData.getClass().getName()).getDeclaredField(config.getJoinColumn());
                firstDataStreamField.setAccessible(true);
                var firstValue = (String) firstDataStreamField.get(firstStreamData);
                Supplier<Stream<?>> streamSupplier = secondStream::findActiveStream;
                streamSupplier.get().forEach(secondStreamData -> {
                    try {
                        var secondDataStreamField = Class.forName(secondStreamData.getClass().getName()).getDeclaredField(config.getJoinColumn());
                        secondDataStreamField.setAccessible(true);
                        var secondValue = (String) secondDataStreamField.get(secondStreamData);
                        if (firstValue.equals(secondValue)) {
                            returnedStream.add(firstStreamData + secondStreamData.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return returnedStream;
    }

    @Override
    public List<String> rightJoin(StreamModels firstStream, StreamModels secondStream) {
        this.getFieldNames();
        if (Boolean.FALSE.equals(this.checkJoinColumn())) {
            return null;
        }
        this.joinMethodName = "get" + (config.getJoinColumn().substring(0, 1).toUpperCase() + config.getJoinColumn().substring(1));
        List<String> returnedStream = new ArrayList<>();
        firstStream.findActiveStream().forEach(firstStreamData -> {
            try {
                var firstDataStreamField = Class.forName(firstStreamData.getClass().getName()).getDeclaredField(config.getJoinColumn());
                firstDataStreamField.setAccessible(true);
                var firstValue = (String) firstDataStreamField.get(firstStreamData);
                Supplier<Stream<?>> streamSupplier = secondStream::findActiveStream;
                streamSupplier.get().forEach(secondStreamData -> {
                    try {
                        var secondDataStreamField = Class.forName(secondStreamData.getClass().getName()).getDeclaredField(config.getJoinColumn());
                        secondDataStreamField.setAccessible(true);
                        var secondValue = (String) secondDataStreamField.get(secondStreamData);
                        if (firstValue.equals(secondValue)) {
                            returnedStream.add(firstStreamData + secondStreamData.toString());
                        }
                        returnedStream.add(secondStreamData.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return returnedStream;
    }

    @Override
    public List<String> leftJoin(StreamModels firstStream, StreamModels secondStream) {
        this.getFieldNames();
        if (Boolean.FALSE.equals(this.checkJoinColumn())) {
            return null;
        }
        this.joinMethodName = "get" + (config.getJoinColumn().substring(0, 1).toUpperCase() + config.getJoinColumn().substring(1));
        List<String> returnedStream = new ArrayList<>();
        firstStream.findActiveStream().forEach(firstStreamData -> {
            try {
                var firstDataStreamField = Class.forName(firstStreamData.getClass().getName()).getDeclaredField(config.getJoinColumn());
                firstDataStreamField.setAccessible(true);
                var firstValue = (String) firstDataStreamField.get(firstStreamData);
                secondStream.findActiveStream().forEach(secondStreamData -> {
                    try {
                        var secondDataStreamField = Class.forName(secondStreamData.getClass().getName()).getDeclaredField(config.getJoinColumn());
                        secondDataStreamField.setAccessible(true);
                        var secondValue = (String) secondDataStreamField.get(secondStreamData);
                        if (firstValue.equals(secondValue)) {
                            returnedStream.add(firstStreamData + secondStreamData.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                returnedStream.add(firstStreamData.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return returnedStream;
    }

    @Override
    public Stream<?> thetaJoin(StreamModels firstStream, StreamModels secondStream) {
        this.getFieldNames();
        if (Boolean.FALSE.equals(this.checkJoinColumn())) {
            return null;
        }
        return null;
    }
}
