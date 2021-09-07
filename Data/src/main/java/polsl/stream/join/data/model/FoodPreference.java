package polsl.stream.join.data.model;

import com.opencsv.bean.CsvBindByPosition;

public class FoodPreference {

    @CsvBindByPosition(position = 0)
    private String timestamp;

    @CsvBindByPosition(position = 1)
    private String participantId;

    @CsvBindByPosition(position = 2)
    private String gender;

    @CsvBindByPosition(position = 3)
    private String nationality;

    @CsvBindByPosition(position = 4)
    private String age;

    @CsvBindByPosition(position = 5)
    private String food;

    @CsvBindByPosition(position = 6)
    private String juice;

    @CsvBindByPosition(position = 7)
    private String dessert;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getJuice() {
        return juice;
    }

    public void setJuice(String juice) {
        this.juice = juice;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "FoodPreference{" +
                "timestamp='" + timestamp + '\'' +
                ", participantId='" + participantId + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age='" + age + '\'' +
                ", food='" + food + '\'' +
                ", juice='" + juice + '\'' +
                ", dessert='" + dessert + '\'' +
                '}';
    }
}
