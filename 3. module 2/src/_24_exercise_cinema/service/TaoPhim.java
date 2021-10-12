package _24_exercise_cinema.service;

import _24_exercise_cinema.models.Phim;
import _24_exercise_cinema.ultils.DocVaGhiPhim;

import java.util.ArrayList;
import java.util.Scanner;

public class TaoPhim implements DichVu {
    Scanner sc = new Scanner(System.in);
    private final String FILE_PHIM_PATH = "src\\_24_exercise_cinema\\data\\phim.csv";

    @Override
    public void add() {
        System.out.println("Nhap ten Phim: ");
        String tenPhim = sc.nextLine();
        Phim phim = new Phim(tenPhim);
        ArrayList<Phim> danhSachPhim = new ArrayList<>();
        danhSachPhim.add(phim);
        DocVaGhiPhim.ghiPhim(danhSachPhim, FILE_PHIM_PATH);

    }

    @Override
    public void display() {
        ArrayList<Phim> danhSachPhim = DocVaGhiPhim.docPhim(FILE_PHIM_PATH);
        for (int i = 0; i < danhSachPhim.size() ; i++) {
            System.out.println(i+1 + ". " + danhSachPhim.get(i));
        }
    }
}
