package utils;


import models.Contract;
import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteContract {
    public static void writeFile(String filePath, ArrayList<Contract> contracts, boolean append) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contract contract:contracts) {
                bufferedWriter.write(contract.getInfoToWrite());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Contract> readFile(String filePath) {
        ArrayList<Contract> contracts = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line ;
            String[] array ;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Contract contract = new Contract(array[1], array[2], Double.parseDouble(array[3]),Double.parseDouble(array[4]));
                contract.setContractNumbers(array[0]);
                Contract.setCode(Integer.parseInt(array[5]));
                contracts.add(contract);

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contracts;
    }
}
