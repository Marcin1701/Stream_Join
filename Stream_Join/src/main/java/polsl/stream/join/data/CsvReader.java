package polsl.stream.join.data;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import polsl.stream.join.data.algorithm.StreamModels;
import polsl.stream.join.data.model.*;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CsvReader {

    private final String resourceUrl;

    private static final Logger logger = LoggerFactory.getLogger(CsvReader.class);

    private final List<String> files = Arrays.stream(new String[]
            {
                    "1_CarData.csv", "1_CarData_Sales.csv",
                    "2_Food_Choices.csv", "2_Food_Preference.csv",
                    "3_Korea_Income_and_Welfare.csv", "3_Test_Income.csv"
            }).toList();

    private StreamModels readFromFile(String filename)  {
        var streamModel = new StreamModels();
        try {
            List<?> data;
            switch (filename) {
                case "1_CarData.csv" -> {
                    data = new CsvToBeanBuilder<CarData>(new FileReader(resourceUrl + filename))
                            .withType(CarData.class)
                            .build()
                            .parse();
                    streamModel.setCarDataStream((Stream<CarData>) data.stream());
                }
                case "1_CarData_Sales.csv" -> {
                    data = new CsvToBeanBuilder<CarDataSales>(new FileReader(resourceUrl + filename))
                            .withType(CarDataSales.class)
                            .build()
                            .parse();
                    streamModel.setCarDataSalesStream((Stream<CarDataSales>) data.stream());
                }
                case "2_Food_Choices.csv" -> {
                    data = new CsvToBeanBuilder<FoodChoices>(new FileReader(resourceUrl + filename))
                            .withType(FoodChoices.class)
                            .build()
                            .parse();
                    streamModel.setFoodChoicesStream((Stream<FoodChoices>) data.stream());
                }
                case "2_FoodPreference.csv" -> {
                    data = new CsvToBeanBuilder<FoodPreference>(new FileReader(resourceUrl + filename))
                            .withType(FoodPreference.class)
                            .build()
                            .parse();
                    streamModel.setFoodPreferenceStream((Stream<FoodPreference>) data.stream());
                }
                case "3_Korea_Income_and_Welfare.csv" -> {
                    data = new CsvToBeanBuilder<KoreaIncome>(new FileReader(resourceUrl + filename))
                            .withType(KoreaIncome.class)
                            .build()
                            .parse();
                    streamModel.setKoreaIncomeStream((Stream<KoreaIncome>) data.stream());
                }
                case "3_Test_Income.csv" -> {
                    data = new CsvToBeanBuilder<TestIncome>(new FileReader(resourceUrl + filename))
                            .withType(TestIncome.class)
                            .build()
                            .parse();
                    streamModel.setTestIncomeStream((Stream<TestIncome>) data.stream());
                }
                default -> logger.error("FILE NOT FOUND!");
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
