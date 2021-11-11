package utils;

import bean.Card;
import service.Impl.CardService;
import service.Impl.CardServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean checkIDCard(String id) {
        String regex = "^MS\\-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);

        if (matcher.matches()){
            CardService cardService = new CardServiceImpl();
            List<Card> cardList = cardService.findAllCard();
            for (Card card :cardList) {
                if (card.getId().contains(id)){
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    public static boolean checkDate(String ngayBatDau, String ngayKetThuc) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate ngayBatDauNew = LocalDate.parse(ngayBatDau,f);
            LocalDate ngayKetThucNew = LocalDate.parse(ngayKetThuc,f);
            if (ngayBatDauNew.isAfter(ngayKetThucNew)){
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
            return false;
        }
        return true;
    }
}
