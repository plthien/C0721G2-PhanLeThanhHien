package _16_io_text_file.exercise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public List<Country> readFileCSV(String filePath) {
        List<Country> countryList = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Country country = new Country(Integer.parseInt(array[0]), array[1], array[2]);
                countryList.add(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryList;

    }
}
