package polsl.stream.join.data.model;

import com.opencsv.bean.CsvBindByPosition;

public class CarDataSales {

    @CsvBindByPosition(position = 0)
    private String manufacturer;

    @CsvBindByPosition(position = 1)
    private String model;

    @CsvBindByPosition(position = 2)
    private String salesINThousands;

    @CsvBindByPosition(position = 3)
    private String yearResaleValue;

    @CsvBindByPosition(position = 4)
    private String vehicleType;

    @CsvBindByPosition(position = 5)
    private String priceInThousands;

    @CsvBindByPosition(position = 6)
    private String engineSize;

    @CsvBindByPosition(position = 7)
    private String hp;

    @CsvBindByPosition(position = 8)
    private String wheelbase;

    @CsvBindByPosition(position = 9)
    private String width;

    @CsvBindByPosition(position = 10)
    private String length;

    @CsvBindByPosition(position = 11)
    private String curbWeight;

    @CsvBindByPosition(position = 12)
    private String fuelCapacity;

    @CsvBindByPosition(position = 13)
    private String fuelEfficiency;

    @CsvBindByPosition(position = 14)
    private String latestLaunch;

    @CsvBindByPosition(position = 15)
    private String powerPerfFactor;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSalesINThousands() {
        return salesINThousands;
    }

    public void setSalesINThousands(String salesINThousands) {
        this.salesINThousands = salesINThousands;
    }

    public String getYearResaleValue() {
        return yearResaleValue;
    }

    public void setYearResaleValue(String yearResaleValue) {
        this.yearResaleValue = yearResaleValue;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPriceInThousands() {
        return priceInThousands;
    }

    public void setPriceInThousands(String priceInThousands) {
        this.priceInThousands = priceInThousands;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(String wheelbase) {
        this.wheelbase = wheelbase;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(String curbWeight) {
        this.curbWeight = curbWeight;
    }

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(String fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getLatestLaunch() {
        return latestLaunch;
    }

    public void setLatestLaunch(String latestLaunch) {
        this.latestLaunch = latestLaunch;
    }

    public String getPowerPerfFactor() {
        return powerPerfFactor;
    }

    public void setPowerPerfFactor(String powerPerfFactor) {
        this.powerPerfFactor = powerPerfFactor;
    }

    public String get(String keyColumn) {
        return " CarDataSales.csv: " + switch (keyColumn) {
            case "manufacturer" -> manufacturer;
            case "model" -> model;
            case "hp" -> hp;
            default -> "";
        } + " Model: " + model;
    }
}
