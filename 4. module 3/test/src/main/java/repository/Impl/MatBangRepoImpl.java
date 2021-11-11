package repository.Impl;

import bean.LoaiMatBang;
import bean.MatBang;
import bean.Tang;
import bean.TrangThai;
import repository.MatBangRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepoImpl implements MatBangRepo {
    @Override
    public List<MatBang> lietKe() {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call liet_ke_mat_bang()}");
            ResultSet resultSet = callableStatement.executeQuery();

            MatBang matBang = null;
            LoaiMatBang loaiMatBang = null;
            TrangThai trangThai = null;
            Tang tang = null;
            while (resultSet.next()) {
                matBang = new MatBang();
                loaiMatBang = new LoaiMatBang();
                trangThai = new TrangThai();
                tang = new Tang();

                matBang.setId(resultSet.getString("id"));
                matBang.setDienTich(resultSet.getDouble("dien_tich"));
                matBang.setGiaTien(resultSet.getDouble("gia_tien"));
                matBang.setNgayBatDau(resultSet.getString("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getString("ngay_ket_thuc"));

                loaiMatBang.setTen(resultSet.getString("ten_loai_mat_bang"));
                trangThai.setTen(resultSet.getString("ten_trang_thai"));
                tang.setTen(resultSet.getString("ten_tang"));

                matBang.setLoaiMatBang(loaiMatBang);
                matBang.setTrangThai(trangThai);
                matBang.setTang(tang);

                matBangList.add(matBang);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return matBangList;
    }

    @Override
    public void luu(MatBang matBang) {
        Connection connection = BaseRepository.connection;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("insert into mat_bang(id,dien_tich,gia_tien,ngay_bat_dau,ngay_ket_thuc,id_trang_thai,id_tang,id_loai_mat_bang) " +
                            " values(?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, matBang.getId());
            preparedStatement.setDouble(2, matBang.getDienTich());
            preparedStatement.setDouble(3, matBang.getGiaTien());
            preparedStatement.setString(4, matBang.getNgayBatDau());
            preparedStatement.setString(5, matBang.getNgayKetThuc());
            preparedStatement.setString(6, matBang.getTrangThai().getId());
            preparedStatement.setString(7, matBang.getTang().getId());
            preparedStatement.setString(8, matBang.getLoaiMatBang().getId());

            int rowAffect = preparedStatement.executeUpdate();

            if (rowAffect == 1) {
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.setAutoCommit(true);

        } catch (SQLException throwables) {
            try {
                connection.rollback();
                System.out.println(throwables.getMessage());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void capNhap(MatBang matBang) {

    }

    @Override
    public void xoa(String id) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("update mat_bang set kha_dung = 0 where id=? ");
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<LoaiMatBang> lietKeLoaiMatBang() {
        List<LoaiMatBang> loaiMatBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from loai_mat_bang ");
            ResultSet resultSet = preparedStatement.executeQuery();

            LoaiMatBang loaiMatBang = null;
            while (resultSet.next()) {
                loaiMatBang = new LoaiMatBang();
                loaiMatBang.setId(resultSet.getString("id"));
                loaiMatBang.setTen(resultSet.getString("ten_loai_mat_bang"));

                loaiMatBangList.add(loaiMatBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return loaiMatBangList;
    }

    @Override
    public List<TrangThai> lietKeTrangThai() {
        List<TrangThai> trangThaiList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from trang_thai ");
            ResultSet resultSet = preparedStatement.executeQuery();

            TrangThai trangThai = null;
            while (resultSet.next()) {
                trangThai = new TrangThai();
                trangThai.setId(resultSet.getString("id"));
                trangThai.setTen(resultSet.getString("ten_trang_thai"));

                trangThaiList.add(trangThai);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return trangThaiList;
    }

    @Override
    public List<Tang> lietKeTang() {
        List<Tang> tangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from tang ");
            ResultSet resultSet = preparedStatement.executeQuery();

            Tang tang = null;
            while (resultSet.next()) {
                tang = new Tang();
                tang.setId(resultSet.getString("id"));
                tang.setTen(resultSet.getString("ten_tang"));

                tangList.add(tang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tangList;
    }
}
