package _16_io_text_file.exercise.copy_file_text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path of source file: ");
        String sourceFilePath = sc.nextLine();
        System.out.println("Enter the path of target file: ");
        String targetFilePath = sc.nextLine();

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<String> list;

        list = readAndWriteFile.readFile(sourceFilePath);
        readAndWriteFile.writeFile(targetFilePath, list);

    }
}
