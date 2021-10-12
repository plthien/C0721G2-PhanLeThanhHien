package models;

import utils.UserException;

import java.util.Scanner;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String ngaySinh;
    private boolean gioiTinh;
    private String soDienThoai;
    private String diaChi;
    Scanner sc = new Scanner(System.in);

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String ngaySinh, boolean gioiTinh, String soDienThoai, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang() {
        System.out.println("Nhap ten Khach hang: ");
        this.tenKhachHang = sc.nextLine();
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh() {
        boolean check = false;
        do {
            System.out.println("Nhap ngay sinh: ");
            this.ngaySinh = sc.nextLine();
            check = UserException.kiemTraNgay(this.ngaySinh);
        } while (!check);
    }

    public String isGioiTinh() {
        return this.gioiTinh ? "Male" : "Female";
    }

    public void setGioiTinh() {
        int choiceGender = 0;
        this.gioiTinh = true;
        do {
            try {
                System.out.println("Enter gender: 1. Nam\t2. Nu ");
                choiceGender = Integer.parseInt(sc.nextLine());
                if (choiceGender == 2) {
                    this.gioiTinh = false;
                } else if (choiceGender != 1) {
                    System.out.println("Chon Lai");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chon Lai");
            }

        } while (choiceGender != 1 && choiceGender != 2);
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai() {
        boolean check = false;
        do {
            try {
                System.out.println("Enter phone number: ");
                this.soDienThoai = sc.nextLine();
                check = UserException.kiemTraSoDienThoai(this.soDienThoai);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (!check);
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        System.out.println("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sc=" + sc +
                '}';
    }


}
