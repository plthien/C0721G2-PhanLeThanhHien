package service.Impl;

import bean.LoaiMatBang;
import bean.MatBang;
import bean.Tang;
import bean.TrangThai;
import repository.Impl.MatBangRepoImpl;
import repository.MatBangRepo;
import service.MatBangService;

import java.util.List;

public class MatBangServiceImpl implements MatBangService {
    private MatBangRepo matBangRepo = new MatBangRepoImpl();
    @Override
    public List<MatBang> lietKe() {
        return matBangRepo.lietKe();
    }

    @Override
    public void luu(MatBang matBang) {
        matBangRepo.luu(matBang);
    }

    @Override
    public void capNhap(MatBang matBang) {
        matBangRepo.capNhap(matBang);
    }

    @Override
    public void xoa(String id) {
        matBangRepo.xoa(id);
    }

    @Override
    public List<LoaiMatBang> lietKeLoaiMatBang() {
        return matBangRepo.lietKeLoaiMatBang();
    }

    @Override
    public List<TrangThai> lietKeTrangThai() {
        return matBangRepo.lietKeTrangThai();
    }

    @Override
    public List<Tang> lietKeTang() {
        return matBangRepo.lietKeTang();
    }
}
