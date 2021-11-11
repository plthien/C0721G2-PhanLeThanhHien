package bean;


public class MatBang {
    private String id;
    private double dienTich;
    private double giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;
    private TrangThai trangThai;
    private LoaiMatBang loaiMatBang;
    private Tang tang;

    public MatBang() {
    }

    public MatBang(String id, double dienTich, double giaTien, String ngayBatDau, String ngayKetThuc, TrangThai trangThai, LoaiMatBang loaiMatBang, Tang tang) {
        this.id = id;
        this.dienTich = dienTich;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.loaiMatBang = loaiMatBang;
        this.tang = tang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public LoaiMatBang getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(LoaiMatBang loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public Tang getTang() {
        return tang;
    }

    public void setTang(Tang tang) {
        this.tang = tang;
    }
}
