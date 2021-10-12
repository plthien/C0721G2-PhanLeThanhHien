package services;

import models.SoTietKiemCoHan;
import models.SoTietKiemVoThoiHan;
import utils.DocVaGhi;

import java.util.ArrayList;

public class SoTietKiemCoHanImpl implements DichVu{
    private final String NGAN_HAN_PATH = "src\\data\\ngan_han.csv";

    @Override
    public void them() {
        ArrayList<SoTietKiemVoThoiHan> danhSachSoTietKiem = DocVaGhi.doc(NGAN_HAN_PATH);
        SoTietKiemCoHan soTietKiemCoHan = new SoTietKiemCoHan();
        boolean flag = true;
        do {
            soTietKiemCoHan.setMaSo();
            for (SoTietKiemVoThoiHan soTietKiem : danhSachSoTietKiem) {
                if (soTietKiem.getMaSo().contains(soTietKiemCoHan.getMaSo())) {
                    System.out.println("Ma so da ton tai, nhap lai");
                    flag = false;
                    break;
                }
            }
        } while (!flag);
        soTietKiemCoHan.setMaKhachHang();
        soTietKiemCoHan.setNgayMoSo();
        soTietKiemCoHan.setNgayGui();
        soTietKiemCoHan.setSoTienGui();
        soTietKiemCoHan.setLaiSuat();
        soTietKiemCoHan.setKyHan();
        danhSachSoTietKiem.add(soTietKiemCoHan);
        DocVaGhi.ghi(NGAN_HAN_PATH,danhSachSoTietKiem,false);
    }

    @Override
    public void xoa() {

    }

    @Override
    public void hienThi() {
        ArrayList<SoTietKiemVoThoiHan> danhSachSoTietKiem = DocVaGhi.doc(NGAN_HAN_PATH);
        for (SoTietKiemVoThoiHan soTietKiemVoThoiHan:danhSachSoTietKiem) {
            System.out.println(soTietKiemVoThoiHan);
        }
    }
}
