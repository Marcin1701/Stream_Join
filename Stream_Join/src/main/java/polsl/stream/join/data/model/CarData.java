package polsl.stream.join.data.model;

import com.opencsv.bean.CsvBindByPosition;

public class CarData {

    @CsvBindByPosition(position = 0)
    private String make;

    @CsvBindByPosition(position = 1)
    private String model;

    @CsvBindByPosition(position = 2)
    private String year;

    @CsvBindByPosition(position = 3)
    private String engineFuelType;

    @CsvBindByPosition(position = 4)
    private String hp;

    @CsvBindByPosition(position = 5)
    private String engineCylinders;

    @CsvBindByPosition(position = 6)
    private String transmission;

    @CsvBindByPosition(position = 7)
    private String driven;

    @CsvBindByPosition(position = 8)
    private String numberOfDoors;

    @CsvBindByPosition(position = 9)
    private String market;

    @CsvBindByPosition(position = 10)
    private String vehicleSize;

    @CsvBindByPosition(position = 11)
    private String vehicleStyle;

    @CsvBindByPosition(position = 12)
    private String highway;

    @CsvBindByPosition(position = 13)
    private String cityMpg;

    @CsvBindByPosition(position = 14)
    private String popularity;

    @CsvBindByPosition(position = 15)
    private String msrp;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngineFuelType() {
        return engineFuelType;
    }

    public void setEngineFuelType(String engineFuelType) {
        this.engineFuelType = engineFuelType;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEngineCylinders() {
        return engineCylinders;
    }

    public void setEngineCylinders(String engineCylinders) {
        this.engineCylinders = engineCylinders;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriven() {
        return driven;
    }

    public void setDriven(String driven) {
        this.driven = driven;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleStyle() {
        return vehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getCityMpg() {
        return cityMpg;
    }

    public void setCityMpg(String cityMpg) {
        this.cityMpg = cityMpg;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String get(String keyColumn) {
        return " CarData.csv: " + switch (keyColumn) {
            case "make" -> make;
            case "model" -> model;
            case "year" -> year;
            case "engineFuelType" -> engineFuelType;
            case "hp" -> hp;
            case "engineCylinders" -> engineCylinders;
            case "transmission" -> transmission;
            case "driven" -> driven;
            case "numberOfDoors" -> numberOfDoors;
            case "market" -> market;
            default -> "";
        } + " Model: " + model;
    }

    @Override
    public String toString() {
        return "CarData{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", hp='" + hp + '\'' +
                '}';
    }
}
