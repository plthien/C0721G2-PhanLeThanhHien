package controllers;

import services.DichVu;
import services.SoTietKiemCoHanImpl;
import services.SoTietKiemDaiHanImpl;
import services.SoTietKiemVoThoiHanImpl;

import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String luaChon;
        DichVu soVoHan = new SoTietKiemVoThoiHanImpl();
        DichVu soCoHan = new SoTietKiemCoHanImpl();
        DichVu soDaiHan = new SoTietKiemDaiHanImpl();
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM –");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm mới sổ tiết kiệm");
            System.out.println("2. Xóa sổ tiết kiệm");
            System.out.println("3. Xem danh sách sổ tiết ");
            System.out.println("4. Thoat ");
            System.out.println("Chon: ");
            luaChon = sc.nextLine();
            switch (luaChon){
                case "1":
                    String luaChonThem;
                    do {
                        System.out.println("1. Them moi so vo thoi han: ");
                        System.out.println("2. Them moi so co han");
                        System.out.println("3. Them moi so dai han");
                        System.out.println("4. Thoat");
                        luaChonThem = sc.nextLine();
                        switch (luaChonThem){
                            case "1":
                                soVoHan.them();
                                break;
                            case "2":
                                soCoHan.them();
                                break;
                            case "3":
                                soDaiHan.them();
                                break;
                            default:
                                System.out.println("Chon lai");
                                break;
                        }
                    }while (!luaChonThem.equals("4"));
                    break;
                case "2":
                    break;
                case "3":
                    System.out.println("So Dai han:");
                    soDaiHan.hienThi();
                    System.out.println("So ngan Han: ");
                    soVoHan.hienThi();
                    break;
            }

        }while (!luaChon.equals("4"));

    }
}
