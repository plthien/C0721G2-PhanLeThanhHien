package _16_io_text_file.exercise.copy_file_text;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<String> readFile(String filePath){
        List<String> list = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line= "";
            while ((line = bufferedReader.readLine())!=null){
                list.add(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("The source file does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public void writeFile(String filePath, List<String> list){
        File file = new File(filePath);
        int count = 0;
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            if (bufferedReader.readLine() != null){
                throw new FileAlreadyExistsException("The target file  existed");
            }
            for (String element : list) {
                count +=element.length();
                bufferedWriter.write(element);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Number of Characters: " +count);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
