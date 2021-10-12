package _24_exercise_cinema.service;

import _24_exercise_cinema.models.Phim;
import _24_exercise_cinema.models.SuatChieuPhim;
import _24_exercise_cinema.ultils.DocVaGhiPhim;
import _24_exercise_cinema.ultils.DocVaGhiSuatChieu;
import org.omg.PortableInterceptor.INACTIVE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaoSuatChieu implements DichVu {
    private final String FILE_SUAT_CHIEU_PATH = "src\\_24_exercise_cinema\\data\\suat_chieu_phim.csv";
    private final String FILE_PHIM_PATH = "src\\_24_exercise_cinema\\data\\phim.csv";
    Scanner sc = new Scanner(System.in);
    DichVu taoPhim = new TaoPhim();

    @Override
    public void add() {
        boolean kiemTra;
        do {
            System.out.println("Nhap ma suat chieu: ");
            String maSuatChieu = sc.nextLine();
            kiemTra = kiemTraMaSuatChieu(maSuatChieu);
        } while (!kiemTra);

        System.out.println("Chon Thu tu Phim: ");
        taoPhim.display();
        ArrayList<Phim> danhSachPhim = DocVaGhiPhim.docPhim(FILE_PHIM_PATH);
        int viTriPhim = Integer.parseInt(sc.nextLine());
        String tenPhim = danhSachPhim.get(viTriPhim - 1).getTenPhim();
        System.out.println("Nhap ngay chieu phim: ");
        String ngayChieuPhim = sc.nextLine();


    }

    @Override
    public void display() {

    }

    public boolean kiemTraMaSuatChieu(String maSuatChieu) {
        ArrayList<SuatChieuPhim> danhSachSuatChieu = DocVaGhiSuatChieu.docPhim(FILE_SUAT_CHIEU_PATH);
        String regex = "CI-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maSuatChieu);
        if (!matcher.matches()) {
            System.out.println("Ma suat chieu khong dung quy dinh");
            return false;
        } else {
            for (SuatChieuPhim suatChieuPhim : danhSachSuatChieu) {
                if (suatChieuPhim.getMaSuatChieu().contains(maSuatChieu)) {
                    System.out.println("Ma suat chieu phim da ton tai");
                    return false;
                }
            }
        }
        return true;
    }

//    public boolean kiemTraNgayChieuPhim(String ngayChieuPhim) {
//        String regex = "^\\d{2}\\/d{2}\\/d{4}$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(ngayChieuPhim);
//        if (matcher.matches()) {
//            LocalDate ngayHienTai = LocalDate.now();
//            LocalDate ngayChieuPhimNew = LocalDate.parse(ngayChieuPhim);
//            if (ngayChieuPhimNew.compareTo(ngayHienTai) <= 0) {
//                System.out.println("Ngay chieu phim phai lon hon ngay hien tai");
//            }
//        }
//    }
}
