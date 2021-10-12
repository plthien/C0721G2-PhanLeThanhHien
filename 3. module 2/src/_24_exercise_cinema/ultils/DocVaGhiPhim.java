package _24_exercise_cinema.ultils;

import _24_exercise_cinema.models.Phim;

import java.io.*;
import java.util.ArrayList;

public class DocVaGhiPhim {
    public static void ghiPhim(ArrayList<Phim> danhSachPhim, String filePath) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Phim phim : danhSachPhim) {
                bufferedWriter.write(phim.getPhim());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Phim> docPhim(String filePath) {
        ArrayList<Phim> danhSachPhim = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Phim phim = new Phim(array[0]);
                danhSachPhim.add(phim);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return danhSachPhim;
    }
}

