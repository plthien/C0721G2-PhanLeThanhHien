package utils;

import models.SoTietKiemCoHan;
import models.SoTietKiemDaiHan;
import models.SoTietKiemVoThoiHan;

import java.io.*;
import java.util.ArrayList;

public class DocVaGhi {
    public static void ghi(String filePath, ArrayList<SoTietKiemVoThoiHan> danhsachSoTietKiem, boolean append) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (SoTietKiemVoThoiHan soTietKiem : danhsachSoTietKiem) {
                bufferedWriter.write(soTietKiem.layThongTin());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<SoTietKiemVoThoiHan> doc(String filePath) {
        ArrayList<SoTietKiemVoThoiHan> danhsachSoTietKiem = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] array;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 6) {
                    SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan(array[0], array[1], array[2],
                            array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]));
                    danhsachSoTietKiem.add(soTietKiemVoThoiHan);
                } else if (array.length == 7) {
                    if (array[6].contains("3 thang")) {
                        SoTietKiemCoHan soTietKiemCoHan = new SoTietKiemCoHan(array[0], array[1], array[2],
                                array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]), 1);
                        danhsachSoTietKiem.add(soTietKiemCoHan);
                    } else {
                        SoTietKiemCoHan soTietKiemCoHan = new SoTietKiemCoHan(array[0], array[1], array[2],
                                array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]), 2);
                        danhsachSoTietKiem.add(soTietKiemCoHan);
                    }
                } else {
                    if (array[6].contains("1 nam")) {
                        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(array[0], array[1], array[2],
                                array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]), 1, array[7]);
                        danhsachSoTietKiem.add(soTietKiemDaiHan);
                    } else if (array[6].contains("3 nam")) {
                        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(array[0], array[1], array[2],
                                array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]), 2, array[7]);
                        danhsachSoTietKiem.add(soTietKiemDaiHan);
                    } else if (array[6].contains("5 nam")) {
                        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(array[0], array[1], array[2],
                                array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]), 3, array[7]);
                        danhsachSoTietKiem.add(soTietKiemDaiHan);
                    } else if (array[6].contains("10 nam")) {
                        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan(array[0], array[1], array[2],
                                array[3], Double.parseDouble(array[4]), Double.parseDouble(array[5]), 4, array[7]);
                        danhsachSoTietKiem.add(soTietKiemDaiHan);
                    }

                }

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return danhsachSoTietKiem;
    }
}
