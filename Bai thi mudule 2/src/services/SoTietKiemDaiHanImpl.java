package services;

import models.SoTietKiemDaiHan;
import models.SoTietKiemVoThoiHan;
import utils.DocVaGhi;

import java.util.ArrayList;

public class SoTietKiemDaiHanImpl implements DichVu {
    private final String DAI_HAN_PATH = "src\\data\\dai_han.csv";

    @Override
    public void them() {
        ArrayList<SoTietKiemVoThoiHan> danhSachSoTietKiem = DocVaGhi.doc(DAI_HAN_PATH);
        SoTietKiemDaiHan soTietKiemDaiHan = new SoTietKiemDaiHan();
        boolean flag = true;
        do {
            soTietKiemDaiHan.setMaSo();
            for (SoTietKiemVoThoiHan soTietKiem : danhSachSoTietKiem) {
                if (soTietKiem.getMaSo().contains(soTietKiemDaiHan.getMaSo())) {
                    System.out.println("Ma so da ton tai, nhap lai");
                    flag = false;
                    break;
                }
            }
        } while (!flag);
        soTietKiemDaiHan.setMaKhachHang();
        soTietKiemDaiHan.setNgayMoSo();
        soTietKiemDaiHan.setNgayGui();
        soTietKiemDaiHan.setSoTienGui();
        soTietKiemDaiHan.setLaiSuat();
        soTietKiemDaiHan.setKyHan();
        soTietKiemDaiHan.setUuDai();
        danhSachSoTietKiem.add(soTietKiemDaiHan);
        DocVaGhi.ghi(DAI_HAN_PATH,danhSachSoTietKiem,false);
    }

    @Override
    public void xoa() {

    }

    @Override
    public void hienThi() {
        ArrayList<SoTietKiemVoThoiHan> danhSachSoTietKiem = DocVaGhi.doc(DAI_HAN_PATH);
        for (SoTietKiemVoThoiHan soTietKiemVoThoiHan:danhSachSoTietKiem) {
            System.out.println(soTietKiemVoThoiHan);
        }
    }
}
