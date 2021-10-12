package _24_exercise_cinema.ultils;

import _24_exercise_cinema.models.Phim;
import _24_exercise_cinema.models.SuatChieuPhim;

import java.io.*;
import java.util.ArrayList;

public class DocVaGhiSuatChieu {
    public static void ghiPhim(ArrayList<SuatChieuPhim> danhSachSuatChieu, String filePath) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (SuatChieuPhim suatChieuPhim : danhSachSuatChieu) {
                bufferedWriter.write(suatChieuPhim.getSuatChieuPhim());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<SuatChieuPhim> docPhim(String filePath) {
        ArrayList<SuatChieuPhim> danhSachSuatChieu = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                SuatChieuPhim suatChieuPhim = new SuatChieuPhim(array[0],array[1],array[2],Integer.parseInt(array[2]));
                danhSachSuatChieu.add(suatChieuPhim);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return danhSachSuatChieu;
    }
}
