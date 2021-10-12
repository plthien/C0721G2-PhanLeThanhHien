package libs;

import models.Facility;
import models.House;
import models.Villa;
import utils.ReadAndWriteFacility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class UserException extends Exception {
    private static final String FILE_HOUSE_PATH = "src\\data\\house.csv";
    private static final String FILE_VILLA_PATH = "src\\data\\villa.csv";
    private static final String FILE_ROOM_PATH = "src\\data\\room.csv";

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public static boolean checkBirthday(String birthday){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate birthdayNew = LocalDate.parse(birthday, f);
            System.out.println(birthdayNew);
            LocalDate now = LocalDate.now();
            System.out.println(now);
            int age = Period.between(birthdayNew, now).getYears();
            if (age >= 101 || age <= 17) {
                System.out.println("Birthday is greater than 17 and less than 101 ");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date!");
            return false;
        }
        return true;
    }

    public static boolean checkPhoneNumber(String phoneNumber) throws UserException {
        String regex = "0\\d{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Your phone number is invalid!");
        }
        return check;
    }

    public static boolean checkEmail(String email) throws UserException {
        String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Your email is invalid!");
        }
        return check;
    }

    public static boolean checkDate(String checkInDate, String checkOutDate) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate checkInDateNew = LocalDate.parse(checkInDate,f);
            LocalDate checkOutDateNew = LocalDate.parse(checkOutDate,f);
            if (checkInDateNew.isAfter(checkOutDateNew)) {
                System.out.println("Checkout Date is greater than checkin Date!");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
            return false;
        }
        return true;
    }

    public static boolean checkServiceName(String serviceName, Facility facility) throws UserException {
        String regex;
        if (facility instanceof Villa) {
            regex = "SVVL-\\d{4}";
        } else if (facility instanceof House) {
            regex = "SVHO-\\d{4}";
        } else {
            regex = "SVRO-\\d{4}";
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(serviceName);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Service name invalid!");
        } else if (serviceName.contains("VL")) {
            Map<Facility, Integer> villa = ReadAndWriteFacility.readFile(FILE_VILLA_PATH);
            Set<Facility> keyVilla = villa.keySet();
            for (Facility key : keyVilla) {
                if (key.getServiceName().contains(serviceName)) {
                    System.out.println("Service name existed!");
                    return false;
                }
            }
        } else if (serviceName.contains("HO")) {
            Map<Facility, Integer> house = ReadAndWriteFacility.readFile(FILE_HOUSE_PATH);
            Set<Facility> keyHouse = house.keySet();
            for (Facility key : keyHouse) {
                if (key.getServiceName().contains(serviceName)) {
                    System.out.println("Service name existed!");
                    return false;
                }
            }
        } else {
            Map<Facility, Integer> room = ReadAndWriteFacility.readFile(FILE_ROOM_PATH);
            Set<Facility> keyRoom = room.keySet();
            for (Facility key : keyRoom) {
               if (key.getServiceName().contains(serviceName)){
                   System.out.println("Service name existed!");
                   return false;
               }
            }
        }

        return check;
    }

    public static boolean checkNoun(String str) throws UserException {
        String regex = "[A-Z][a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean check = matcher.matches();
        if (!check) {
            throw new UserException("Service name invalid!");
        }
        return check;
    }


}
