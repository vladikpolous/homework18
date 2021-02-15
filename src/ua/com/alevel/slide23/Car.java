package ua.com.alevel.slide23;

import java.util.Arrays;

public class Car {
    private String brand;
    private String model;
    private String[] colors;
    private String maxSpeedUnit;
    private Integer value;
    private Double volume;
    private Integer rpm;
    private String compressionRatio;
    private Integer seatingCapacity;

    Car(String brand, String model, String[] colors, String maxSpeedUnit, Integer value, Double volume, Integer rpm, String compressionRatio, Integer seatingCapacity){
        this.brand = brand;
        this.model = model;
        this.colors = colors;
        this.maxSpeedUnit = maxSpeedUnit;
        this.value = value;
        this.volume = volume;
        this.rpm = rpm;
        this.compressionRatio = compressionRatio;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colors=" + Arrays.toString(colors) +
                ", maxSpeedUnit='" + maxSpeedUnit + '\'' +
                ", value=" + value +
                ", volume=" + volume +
                ", rpm=" + rpm +
                ", compressionRatio=" + compressionRatio +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public Integer getRpm() {
        return rpm;
    }

    public Double getVolume() {
        return volume;
    }

    public Integer getValue() {
        return value;
    }

    public String getMaxSpeedUnit() {
        return maxSpeedUnit;
    }

    public String[] getColors() {
        return colors;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
}
