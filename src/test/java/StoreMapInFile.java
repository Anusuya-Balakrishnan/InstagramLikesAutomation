import java.io.*;
import java.util.*;

public class StoreMapInFile {
    public static void main(String[] args) {
        // Create a sample map
        Map<String, String> sampleMap = new HashMap();
        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");
        sampleMap.put("key3", "value3");

        // Specify the file path
        String filePath = "map_data.txt";

        try {
            // Create a FileWriter and PrintWriter to write the map data to the file
            FileWriter fileWriter = new FileWriter(filePath,false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Map.Entry<String, String> entry : sampleMap.entrySet()) {
                printWriter.println(entry.getKey() + "=" + entry.getValue());
            }

            // Close the PrintWriter and FileWriter
            printWriter.close();
            fileWriter.close();

            System.out.println("Map data has been written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading the map data from the file (optional)
        try {
            // Create a FileReader and BufferedReader to read the map data from the file
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            Map<String, String> loadedMap = new HashMap();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    loadedMap.put(parts[0], parts[1]);
                }
            }

            // Print the loaded map (optional)
            for (Map.Entry<String, String> entry : loadedMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            // Close the BufferedReader and FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
