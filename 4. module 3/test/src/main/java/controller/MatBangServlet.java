package controller;

import bean.LoaiMatBang;
import bean.MatBang;
import bean.Tang;
import bean.TrangThai;
import service.Impl.MatBangServiceImpl;
import service.MatBangService;
import utils.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = {"", "/matbang"})
public class MatBangServlet extends HttpServlet {
    private MatBangService matBangService = new MatBangServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction) {
            case "create":
                taoMatBang(request, response);
                break;
//            case "edit":
//                updateContract(request,response);
//                break;
//            case "search":
//                searchContract(request,response);
//                break;
//            case "createDetail":
//                createContractDetail(request,response);
//                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction) {
            case "create":
                formTaoMatBang(request, response);
                break;
//                case "edit":
//                    showEditContractForm(request, response);
//                    break;
                case "delete":
                    xoaMatBang(request, response);
                    break;
//                case "contractDetail":
//                    contractDetailList(request, response);
//                    break;
//                case "createDetail":
//                    showCreateContractDetailForm(request, response);
//                    break;
//                case "deleteContractDetail":
//                    deleteContractDetail(request, response);
//                    break;
            default:
                danhSachMatBang(request, response);
                break;

        }
    }

    public void danhSachMatBang(HttpServletRequest request, HttpServletResponse response){
        List<MatBang> matBangList = matBangService.lietKe();
        request.setAttribute("matBangList",matBangList);
        try {
            request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void formTaoMatBang(HttpServletRequest request, HttpServletResponse response){
        List<LoaiMatBang> loaiMatBangList = matBangService.lietKeLoaiMatBang();
        List<TrangThai> trangThaiList =matBangService.lietKeTrangThai();
        List<Tang> tangList = matBangService.lietKeTang();

        request.setAttribute("loaiMatBangList",loaiMatBangList);
        request.setAttribute("trangThaiList",trangThaiList);
        request.setAttribute("tangList",tangList);

        try {
            request.getRequestDispatcher("/pages/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void taoMatBang(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String idTrangThai = request.getParameter("trangThai");
        String idTang = request.getParameter("tang");
        String idLoaiMatBang = request.getParameter("loaiMatBang");
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");

        String idMess = null;
        String dienTichMess = null;
        String giaTienMess = null;
        String ngayMess = null;
        boolean flag = false;

        if (!Validate.checkID(id)){
            idMess = "ID khong hop le";
            flag = true;
        }

        if (!Validate.checkDate(ngayBatDau,ngayKetThuc)){
            ngayMess = "Ngay khong hop le";
            flag = true;
        }

        double dienTich = 0d;
        try {
            dienTich = Double.parseDouble(request.getParameter("dienTich"));
            if (dienTich <= 20){
                dienTichMess = "Dien tich khong hop le";
                flag = true;
            }
        } catch (NumberFormatException e){
            dienTichMess = "Dien tich khong hop le";
            flag = true;
        }

        double giaTien = 0d;
        try {
            giaTien = Double.parseDouble(request.getParameter("giaTien"));
            if (giaTien <= 1000000){
                giaTienMess = "Gia tien khong hop le";
                flag = true;
            }
        } catch (NumberFormatException e){
            giaTienMess = "Gia tien khong hop le";
            flag = true;
        }

        MatBang matBang = new MatBang();
        matBang.setId(id);
        matBang.setDienTich(dienTich);
        matBang.setGiaTien(giaTien);
        matBang.setNgayBatDau(ngayBatDau);
        matBang.setNgayKetThuc(ngayKetThuc);

        LoaiMatBang loaiMatBang = new LoaiMatBang();
        loaiMatBang.setId(idLoaiMatBang);

        Tang tang = new Tang();
        tang.setId(idTang);

        TrangThai trangThai = new TrangThai();
        trangThai.setId(idTrangThai);

        matBang.setTang(tang);
        matBang.setTrangThai(trangThai);
        matBang.setLoaiMatBang(loaiMatBang);
        if (flag) {
            request.setAttribute("idMess", idMess);
            request.setAttribute("dienTichMess", dienTichMess);
            request.setAttribute("giaTienMess", giaTienMess);
            request.setAttribute("ngayMess", ngayMess);
            request.setAttribute("matBang",matBang);
            formTaoMatBang(request,response);
        } else {
            try {
                matBangService.luu(matBang);
                response.sendRedirect("/matbang");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void xoaMatBang(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        matBangService.xoa(id);

        try {
            response.sendRedirect("/matbang");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
