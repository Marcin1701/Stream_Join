package polsl.stream.join.data.model;

import com.opencsv.bean.CsvBindByPosition;

public class TestIncome {

    @CsvBindByPosition(position = 0)
    private String age;

    @CsvBindByPosition(position = 1)
    private String workClass;

    @CsvBindByPosition(position = 2)
    private String fnlwgt;

    @CsvBindByPosition(position = 3)
    private String education;

    @CsvBindByPosition(position = 4)
    private String educationalNum;

    @CsvBindByPosition(position = 5)
    private String martialStatus;

    @CsvBindByPosition(position = 6)
    private String occupation;

    @CsvBindByPosition(position = 7)
    private String relationship;

    @CsvBindByPosition(position = 8)
    private String race;

    @CsvBindByPosition(position = 9)
    private String gender;

    @CsvBindByPosition(position = 10)
    private String capitalLoss;

    @CsvBindByPosition(position = 11)
    private String hoursPerWeek;

    @CsvBindByPosition(position = 12)
    private String nativeCountry;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWorkClass() {
        return workClass;
    }

    public void setWorkClass(String workClass) {
        this.workClass = workClass;
    }

    public String getFnlwgt() {
        return fnlwgt;
    }

    public void setFnlwgt(String fnlwgt) {
        this.fnlwgt = fnlwgt;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationalNum() {
        return educationalNum;
    }

    public void setEducationalNum(String educationalNum) {
        this.educationalNum = educationalNum;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCapitalLoss() {
        return capitalLoss;
    }

    public void setCapitalLoss(String capitalLoss) {
        this.capitalLoss = capitalLoss;
    }

    public String getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(String hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getNativeCountry() {
        return nativeCountry;
    }

    public void setNativeCountry(String nativeCountry) {
        this.nativeCountry = nativeCountry;
    }

    @Override
    public String toString() {
        return "TestIncome{" +
                "age='" + age + '\'' +
                ", workClass='" + workClass + '\'' +
                ", fnlwgt='" + fnlwgt + '\'' +
                ", education='" + education + '\'' +
                ", educationalNum='" + educationalNum + '\'' +
                ", martialStatus='" + martialStatus + '\'' +
                ", occupation='" + occupation + '\'' +
                ", relationship='" + relationship + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", capitalLoss='" + capitalLoss + '\'' +
                ", hoursPerWeek='" + hoursPerWeek + '\'' +
                ", nativeCountry='" + nativeCountry + '\'' +
                '}';
    }
}
