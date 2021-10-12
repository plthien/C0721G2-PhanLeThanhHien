package services;

import models.SoTietKiemVoThoiHan;
import utils.DocVaGhi;

import java.util.ArrayList;

public class SoTietKiemVoThoiHanImpl implements DichVu {
    private final String NGAN_HAN_PATH = "src\\data\\ngan_han.csv";

    @Override
    public void them() {
        ArrayList<SoTietKiemVoThoiHan> danhSachSoTietKiem = DocVaGhi.doc(NGAN_HAN_PATH);
        SoTietKiemVoThoiHan soTietKiemVoThoiHan = new SoTietKiemVoThoiHan();
        boolean flag = true;
        do {
            soTietKiemVoThoiHan.setMaSo();
            for (SoTietKiemVoThoiHan soTietKiem : danhSachSoTietKiem) {
                if (soTietKiem.getMaSo().contains(soTietKiemVoThoiHan.getMaSo())) {
                    System.out.println("Ma so da ton tai, nhap lai");
                    flag = false;
                    break;
                }
            }
        } while (!flag);
        soTietKiemVoThoiHan.setMaKhachHang();
        soTietKiemVoThoiHan.setNgayMoSo();
        soTietKiemVoThoiHan.setNgayGui();
        soTietKiemVoThoiHan.setSoTienGui();
        soTietKiemVoThoiHan.setLaiSuat();
        danhSachSoTietKiem.add(soTietKiemVoThoiHan);
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
