package utils;

import bean.MatBang;
import service.Impl.MatBangServiceImpl;
import service.MatBangService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean checkID(String id) {
        String regex = "^[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);

        if (matcher.matches()){
            MatBangService matBangService = new MatBangServiceImpl();
            List<MatBang> matBangList = matBangService.lietKe();
            for (MatBang matBang :matBangList) {
                if (matBang.getId().contains(id)){
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean checkDate(String ngayBatDau, String ngayKetThuc) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate ngayBatDauNew = LocalDate.parse(ngayBatDau,f);
            LocalDate ngayKetThucNew = LocalDate.parse(ngayKetThuc,f);
            Period diff = Period.between(ngayBatDauNew,ngayKetThucNew);
            if (diff.getMonths()< 6){
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
            return false;
        }
        return true;
    }
}
