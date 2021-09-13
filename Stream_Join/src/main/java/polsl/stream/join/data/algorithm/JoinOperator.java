package polsl.stream.join.data.algorithm;

import org.springframework.stereotype.Component;
import polsl.stream.join.data.algorithm.join.Join;
import polsl.stream.join.data.model.*;

import java.util.stream.Stream;

@Component
public class JoinOperator {

    StreamModels first;

    StreamModels second;

    Stream<CarData> carDataStream;

    Stream<CarDataSales> carDataSalesStream;

    Stream<FoodChoices> foodChoicesStream;

    Stream<FoodPreference> foodPreferenceStream;

    Stream<KoreaIncome> koreaIncomeStream;

    Stream<TestIncome> testIncomeStream;

    public void configureAndValidateStream(Config config) {
        switch (config.getFirstFile()) {
            case "1_CarData.csv" -> carDataStream = (Stream<CarData>) this.first.findActiveStream();
            case "1_CarData_Sales.csv" -> carDataSalesStream = (Stream<CarDataSales>) this.first.findActiveStream();
            case "2_Food_Choices.csv" -> foodChoicesStream = (Stream<FoodChoices>) this.first.findActiveStream();
            case "2_Food_Preference.csv" -> foodPreferenceStream = (Stream<FoodPreference>) this.first.findActiveStream();
            case "3_Korea_Income_and_Welfare.csv" -> koreaIncomeStream = (Stream<KoreaIncome>) this.first.findActiveStream();
            case "3_Test_Income" -> testIncomeStream = (Stream<TestIncome>) this.first.findActiveStream();
        }
        switch (config.getSecondFile()) {
            case "1_CarData.csv" -> carDataStream = (Stream<CarData>) this.second.findActiveStream();
            case "1_CarData_Sales.csv" -> carDataSalesStream = (Stream<CarDataSales>) this.second.findActiveStream();
            case "2_Food_Choices.csv" -> foodChoicesStream = (Stream<FoodChoices>) this.second.findActiveStream();
            case "2_Food_Preference.csv" -> foodPreferenceStream = (Stream<FoodPreference>) this.second.findActiveStream();
            case "3_Korea_Income_and_Welfare.csv" -> koreaIncomeStream = (Stream<KoreaIncome>) this.second.findActiveStream();
            case "3_Test_Income" -> testIncomeStream = (Stream<TestIncome>) this.second.findActiveStream();
        }
        if ((this.carDataStream != null && this.carDataSalesStream == null) ||
            (this.foodChoicesStream != null && this.foodPreferenceStream == null) ||
            (this.koreaIncomeStream != null && this.testIncomeStream == null)) {
            throw new IllegalArgumentException("Streams mismatch");
        }
    }

    public Stream<?> join(StreamModels first, StreamModels second, Config config) {
        this.first = first;
        this.second = second;
        this.configureAndValidateStream(config);
        if (this.carDataStream != null && this.carDataSalesStream != null) {
            return Join.join(this.carDataStream)
                    .withKey(CarData::getHp)
                    .on(this.carDataSalesStream)
                    .withKey(CarDataSales::getHp)
                    .combine((x1, y1) -> x1.get(config.getJoinColumn()) + y1.get(config.getJoinColumn()))
                    .asStream();
        }
        else if (this.foodChoicesStream != null && this.foodPreferenceStream != null) {
            return Join.join(this.foodChoicesStream)
                    .withKey(FoodChoices::getBreakfast)
                    .on(this.foodPreferenceStream)
                    .withKey(FoodPreference::getFood)
                    .combine((x1, y1) -> x1.toString() + y1.toString())
                    .asStream();
        }
        else if (this.koreaIncomeStream != null && this.testIncomeStream != null) {
            return Join.join(this.koreaIncomeStream)
                    .withKey(KoreaIncome::getIncome)
                    .on(this.testIncomeStream)
                    .withKey(TestIncome::getFnlwgt)
                    .combine((x1, y1) -> x1.toString() + y1.toString())
                    .asStream();
        }
        return null;
    }
}
