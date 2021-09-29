package utils;

import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteFacility {
    public static void writeFile(String filePath, Map<Facility, Integer> facilities, boolean append) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Set<Facility> facilitySet = facilities.keySet();
            for (Facility key : facilitySet) {
                bufferedWriter.write(key.getInfoToWrite() + "," + facilities.get(key));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFile(String filePath) {
        Map<Facility, Integer> facilities = new LinkedHashMap<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 7) {
                    facilities.put(new Room(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Integer.parseInt(array[3]),
                            array[4], array[5]), Integer.parseInt(array[6]));
                } else if (array.length == 8) {
                    facilities.put(new House(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Integer.parseInt(array[3]),
                            array[4], array[5], Integer.parseInt(array[6])), Integer.parseInt(array[7]));
                } else {
                    facilities.put(new Villa(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Integer.parseInt(array[3]),
                            array[4], array[5], Double.parseDouble(array[6]), Integer.parseInt(array[7])), Integer.parseInt(array[8]));
                }

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return facilities;
    }

}
