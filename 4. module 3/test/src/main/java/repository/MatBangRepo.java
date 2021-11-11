package repository;

import bean.LoaiMatBang;
import bean.MatBang;
import bean.Tang;
import bean.TrangThai;

import java.util.List;

public interface MatBangRepo {
    List<MatBang> lietKe();

    void luu(MatBang matBang);

    void capNhap(MatBang matBang);

    void xoa(String id);

    List<LoaiMatBang> lietKeLoaiMatBang();

    List<TrangThai> lietKeTrangThai();

    List<Tang> lietKeTang();

}
