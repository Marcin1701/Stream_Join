package polsl.stream.join.data;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import polsl.stream.join.data.algorithm.StreamModels;
import polsl.stream.join.data.model.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CsvReader {

    private final String resourceUrl;

    private static final Logger logger = LoggerFactory.getLogger(CsvReader.class);

    private List<?> data = new ArrayList<>();

    private final List<String> files = Arrays.stream(new String[]
            {
                    "1_CarData.csv", "1_CarData_Sales.csv",
                    "2_Food_Choices.csv", "2_FoodPreference.csv",
                    "3_Korea_Income_and_Welfare.csv", "3_Test_Income.csv"
            }).toList();

    private StreamModels readFromFile(String filename)  {
        var streamModel = new StreamModels();
        try {
            switch (filename) {
                case "1_CarData.csv" -> {
                    this.data = new CsvToBeanBuilder<CarData>(new FileReader(resourceUrl + filename))
                            .withType(CarData.class)
                            .build()
                            .parse();
                    streamModel.setCarDataStream((Stream<CarData>) this.data.stream());
                }
                case "1_CarData_Sales.csv" -> {
                    this.data = new CsvToBeanBuilder<CarDataSales>(new FileReader(resourceUrl + filename))
                            .withType(CarDataSales.class)
                            .build()
                            .parse();
                    streamModel.setCarDataSalesStream((Stream<CarDataSales>) this.data.stream());
                }
                case "2_Food_Choices.csv" -> {
                    this.data = new CsvToBeanBuilder<FoodChoices>(new FileReader(resourceUrl + filename))
                            .withType(FoodChoices.class)
                            .build()
                            .parse();
                    streamModel.setFoodChoicesStream((Stream<FoodChoices>) this.data.stream());
                }
                case "2_FoodPreference.csv" ->
                    this.data = new CsvToBeanBuilder<FoodPreference>(new FileReader(resourceUrl + filename))
                            .withType(FoodPreference.class)
                            .build()
                            .parse();
                case "3_Korea_Income_and_Welfare.csv" ->
                    this.data = new CsvToBeanBuilder<KoreaIncome>(new FileReader(resourceUrl + filename))
                            .withType(KoreaIncome.class)
                            .build()
                            .parse();
                case "3_Test_Income.csv" ->
                    this.data = new CsvToBeanBuilder<TestIncome>(new FileReader(resourceUrl + filename))
                            .withType(TestIncome.class)
                            .build()
                            .parse();

                default -> this.data = new ArrayList<>();
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return streamModel;
    }

    public CsvReader(@Value("${resource.url}") String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public StreamModels readDataFromFile(String filename) {
        return this.readFromFile(filename);
    }

    public List<String> getFileNames() {
        return this.files;
    }
}
