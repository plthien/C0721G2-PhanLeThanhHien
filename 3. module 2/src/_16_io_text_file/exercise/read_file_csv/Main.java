package _16_io_text_file.exercise.read_file_csv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFileCSV readFileCSV = new ReadFileCSV();
        List<Country> countryList = readFileCSV.readFileCSV("src\\_16_io_text_file\\exercise\\read_file_csv\\file.csv");
        for (Country country:countryList) {
            System.out.println(country.toString());
        }
    }
}
