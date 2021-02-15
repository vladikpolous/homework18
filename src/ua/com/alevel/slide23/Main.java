package ua.com.alevel.slide23;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args)  {
        Car car1 = new Car("Toyota",
                "Camry", new String[]{"red", "blue"}, "km/h", 230, 3.5, 5400,
                "11.8:1", 5);
        File file = new File("output.json");
        Json json = new Json();
        Map<String, Object> map = creatMaps(car1);
        json.createJsonFile(file,map);

    }
    public static Map<String, Object> creatMaps(Car car) {
        Map<String, Object> cars = new TreeMap<>();
        Map<String, Object> maxSpeed = new TreeMap<>();
        Map<String, Object> engine = new TreeMap<>();

        cars.put("brand", car.getBrand());
        cars.put("model", car.getModel());
        cars.put("Colors", car.getColors());
        maxSpeed.put("unit", car.getMaxSpeedUnit());
        maxSpeed.put("value", car.getValue());
        engine.put("volume", car.getVolume());
        engine.put("rpm", car.getRpm());
        engine.put("compressionRatio", car.getCompressionRatio());
        cars.put("seatingCapacity", car.getSeatingCapacity());

        cars.put("maxSpeed", maxSpeed);
        cars.put("engine", engine);
        return cars;
    }
}
