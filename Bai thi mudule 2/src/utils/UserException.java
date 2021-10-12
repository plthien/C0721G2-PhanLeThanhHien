package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }


    public static boolean kiemTraNgay(String date){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate birthdayNew = LocalDate.parse(date, f);
            System.out.println(birthdayNew);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date!");
            return false;
        }
        return true;
    }

    public static boolean kiemTraNgay(String ngayMoSo, String ngayGui) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate ngayMoSoMoi = LocalDate.parse(ngayMoSo,f);
            LocalDate ngayGuiMoi = LocalDate.parse(ngayGui,f);
            if (ngayMoSoMoi.isAfter(ngayGuiMoi)) {
                System.out.println("Ngay gui phai sau ngay mo so!");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
            return false;
        }
        return true;
    }

    public static boolean kiemTraSoDienThoai(String phoneNumber) throws UserException {
        String regex = "0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("So dien thoai khong dung!");
        }
        return check;
    }

    public static  boolean kiemTraMaSo(String maSo) throws UserException {
        String regex = "^STK-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(maSo);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Ma so khong dung!");
        }
        return check;
    }
}
