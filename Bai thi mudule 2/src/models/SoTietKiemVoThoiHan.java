package models;

import utils.UserException;

import java.util.Scanner;

public class SoTietKiemVoThoiHan {
    private String maSo;
    private String maKhachHang;
    private String ngayMoSo;
    private String ngayGui;
    private double soTienGui;
    private double laiSuat;
    Scanner sc = new Scanner(System.in);

    public SoTietKiemVoThoiHan() {
    }

    public SoTietKiemVoThoiHan(String maSo, String maKhachHang, String ngayMoSo, String ngayGui, double soTienGui, double laiSuat) {
        this.maSo = maSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.ngayGui = ngayGui;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo() {
        boolean flag =true;
        do {
            try {
                System.out.println("Nhap ma so tiet kiem: ");
                this.maSo = sc.nextLine();
                flag = UserException.kiemTraMaSo(this.maSo);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }while (!flag);

    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang() {
        System.out.println("Nhap ma khach hang: ");
        this.maKhachHang = sc.nextLine();
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo() {
        boolean check = false;
        do {
            System.out.println("Nhap ngay mo so: ");
            this.ngayMoSo = sc.nextLine();
            check = UserException.kiemTraNgay(this.ngayMoSo);
        } while (!check);
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui() {
        boolean check = false;
        do {
            System.out.println("Nhap ngay gui: ");
            this.ngayGui = sc.nextLine();
            check = UserException.kiemTraNgay(this.ngayMoSo, this.ngayGui);
        } while (!check);
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui() {
        do {
            try {
                System.out.println("Nhap so tien gui: ");
                this.soTienGui = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Khong phai la so!");
            }
            if (this.soTienGui < 1000000) {
                System.out.println("So tien gui phai lon hon 1.000.000");
            }

        } while (this.soTienGui < 1000000);
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat() {
        do {
            try {
                System.out.println("Nhap lai suat: ");
                this.laiSuat = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Day khong phai la so!");
            }
            if (this.laiSuat <= 0) {
                System.out.println("Lai suat phai lon hon 0");
            }
        } while (this.laiSuat <= 0);
    }

    public String layThongTin() {
        return this.maSo + "," + this.maKhachHang + "," + this.ngayMoSo + "," + this.ngayGui + "," + this.soTienGui + "," + this.laiSuat;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "maSo='" + maSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", ngayGui='" + ngayGui + '\'' +
                ", soTienGui=" + soTienGui +
                ", laiSuat=" + laiSuat +
                '}';
    }
}
