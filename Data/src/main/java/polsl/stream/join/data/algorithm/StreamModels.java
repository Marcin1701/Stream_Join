package polsl.stream.join.data.algorithm;

import polsl.stream.join.data.model.*;

import java.util.stream.Stream;

public class StreamModels {

    private Stream<CarData> carDataStream;

    private Stream<CarDataSales> carDataSalesStream;

    private Stream<FoodChoices> foodChoicesStream;

    private Stream<FoodPreference> foodPreferenceStream;

    private Stream<KoreaIncome> koreaIncomeStream;

    private Stream<TestIncome> testIncomeStream;

    public Stream<CarData> getCarDataStream() {
        return carDataStream;
    }

    public void setCarDataStream(Stream<CarData> carDataStream) {
        this.carDataStream = carDataStream;
    }

    public Stream<CarDataSales> getCarDataSalesStream() {
        return carDataSalesStream;
    }

    public void setCarDataSalesStream(Stream<CarDataSales> carDataSalesStream) {
        this.carDataSalesStream = carDataSalesStream;
    }

    public Stream<FoodChoices> getFoodChoicesStream() {
        return foodChoicesStream;
    }

    public void setFoodChoicesStream(Stream<FoodChoices> foodChoicesStream) {
        this.foodChoicesStream = foodChoicesStream;
    }

    public Stream<FoodPreference> getFoodPreferenceStream() {
        return foodPreferenceStream;
    }

    public void setFoodPreferenceStream(Stream<FoodPreference> foodPreferenceStream) {
        this.foodPreferenceStream = foodPreferenceStream;
    }

    public Stream<KoreaIncome> getKoreaIncomeStream() {
        return koreaIncomeStream;
    }

    public void setKoreaIncomeStream(Stream<KoreaIncome> koreaIncomeStream) {
        this.koreaIncomeStream = koreaIncomeStream;
    }

    public Stream<TestIncome> getTestIncomeStream() {
        return testIncomeStream;
    }

    public void setTestIncomeStream(Stream<TestIncome> testIncomeStream) {
        this.testIncomeStream = testIncomeStream;
    }

    @Override
    public String toString() {
        var info = "Stream models definition existance:";
        if (this.carDataStream != null) {
            info += " Car data stream";
        }
        if (this.carDataSalesStream != null) {
            info += " Car data sale stream";
        }
        if (this.foodChoicesStream != null) {
            info += " Food choices stream";
        }
        if (this.foodPreferenceStream != null) {
            info = " Food preferences stream";
        }
        if (this.koreaIncomeStream != null) {
            info += " Korea income stream";
        }
        if (this.testIncomeStream != null) {
            info += " Test income stream";
        }
        return info;
    }
}
