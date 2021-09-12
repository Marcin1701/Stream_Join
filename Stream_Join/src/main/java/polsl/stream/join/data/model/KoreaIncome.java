package polsl.stream.join.data.model;

import com.opencsv.bean.CsvBindByPosition;

public class KoreaIncome {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String year;

    @CsvBindByPosition(position = 2)
    private String wave;

    @CsvBindByPosition(position = 3)
    private String region;

    @CsvBindByPosition(position = 4)
    private String income;

    @CsvBindByPosition(position = 5)
    private String familyMember;

    @CsvBindByPosition(position = 6)
    private String yearBorn;

    @CsvBindByPosition(position = 7)
    private String educationLevel;

    @CsvBindByPosition(position = 8)
    private String marriage;

    @CsvBindByPosition(position = 9)
    private String religion;

    @CsvBindByPosition(position = 10)
    private String occupation;

    @CsvBindByPosition(position = 11)
    private String companySize;

    @CsvBindByPosition(position = 12)
    private String reasonNoneWorker;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public String getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(String yearBorn) {
        this.yearBorn = yearBorn;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getReasonNoneWorker() {
        return reasonNoneWorker;
    }

    public void setReasonNoneWorker(String reasonNoneWorker) {
        this.reasonNoneWorker = reasonNoneWorker;
    }

    @Override
    public String toString() {
        return "KoreaIncome{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", wave='" + wave + '\'' +
                ", region='" + region + '\'' +
                ", income='" + income + '\'' +
                ", familyMember='" + familyMember + '\'' +
                ", yearBorn='" + yearBorn + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", marriage='" + marriage + '\'' +
                ", religion='" + religion + '\'' +
                ", occupation='" + occupation + '\'' +
                ", companySize='" + companySize + '\'' +
                ", reasonNoneWorker='" + reasonNoneWorker + '\'' +
                '}';
    }
}
