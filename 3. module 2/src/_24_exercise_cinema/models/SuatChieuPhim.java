package _24_exercise_cinema.models;

import _24_exercise_cinema.models.Phim;

public class SuatChieuPhim {
    private String maSuatChieu;
    private String tenPhim;
    private String ngayChieuPhim;
    private int soLuongVe;

    public SuatChieuPhim() {
    }

    public SuatChieuPhim(String maSuatChieu, String tenPhim, String ngayChieuPhim, int soLuongVe) {
        this.maSuatChieu = maSuatChieu;
        this.tenPhim = tenPhim;
        this.ngayChieuPhim = ngayChieuPhim;
        this.soLuongVe = soLuongVe;
    }


    public String getMaSuatChieu() {
        return maSuatChieu;
    }

    public void setMaSuatChieu(String maSuatChieu) {
        this.maSuatChieu = maSuatChieu;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getNgayChieuPhim() {
        return ngayChieuPhim;
    }

    public void setNgayChieuPhim(String ngayChieuPhim) {
        this.ngayChieuPhim = ngayChieuPhim;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public String getSuatChieuPhim(){
        return this.maSuatChieu + "," + this.tenPhim + "," + this.ngayChieuPhim + "," + this.soLuongVe;
    }

    @Override
    public String toString() {
        return "SuatChieuPhim{" +
                "maSuatChieu='" + maSuatChieu + '\'' +
                ", phim=" + tenPhim +
                ", ngayChieuPhim='" + ngayChieuPhim + '\'' +
                ", soLuongVe=" + soLuongVe +
                '}';
    }
}
