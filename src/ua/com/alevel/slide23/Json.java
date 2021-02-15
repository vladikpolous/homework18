package ua.com.alevel.slide23;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Json {
    public static final String ENTER = "\n";
    public static final String TABULATION = "\t";
    public static final String QUOTES = "\"";
    private static final String COMMA = ",";
    private static final String DOUBLEDOT = ":";

    public void createJsonFile(File file, Map<String, Object> map) {
        try (FileWriter writer = new FileWriter(file)) {
            startWrite(writer);
            writeContent(map, writer);
            endWrite(writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeContent(Map<String, Object> map, FileWriter writer) throws IOException {
        int iteration = 0;
        for (Map.Entry<String, Object> entryMap : map.entrySet()) {
            StringBuilder row = new StringBuilder();
            StringBuilder key = formatSting(entryMap.getKey());
            if (entryMap.getValue() instanceof Map) {
                writer.write(TABULATION + key + DOUBLEDOT + " {" + ENTER);
                writeContent((Map<String, Object>) entryMap.getValue(), writer);
                writer.append(TABULATION + "}");
            } else {
                StringBuilder value = formatSting(entryMap.getValue());
                row.append(TABULATION + key + DOUBLEDOT + " " + value);
                writer.write(String.valueOf(row));
            }
            iteration++;
            if (iteration < map.size()) {
                writer.append(COMMA + ENTER);
            } else {
                writer.append(ENTER);
            }
        }
    }

    private StringBuilder formatSting(Object value) {
        StringBuilder stringBuilder = new StringBuilder();
        if (value.getClass().isArray()) {
            String[] arr = (String[]) value;
            stringBuilder.append("[");
            for (int i = 0; i < arr.length; i++) {
                stringBuilder.append(QUOTES + arr[i] + QUOTES);
                if (i < arr.length - 1) {
                    stringBuilder.append(COMMA);
                }
            }
            stringBuilder.append("]");
        } else if (value instanceof Integer || value instanceof Double) {
            stringBuilder.append(value);
        } else {
            stringBuilder.append(QUOTES + value + QUOTES);
        }
        return stringBuilder;
    }

    private void startWrite(FileWriter writer) throws IOException {
        writer.write(TABULATION + "{" + ENTER);
    }

    private void endWrite(FileWriter writer) throws IOException {
        writer.write(TABULATION + "}");
    }
}
