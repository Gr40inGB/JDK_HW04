package org.gr40in;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Employer {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private Long staffId;
    private String name;
    private Long phoneNumber;
    private LocalDate hiredDate;

    public Employer(Long staffId, String name, Long phoneNumber, LocalDate hiredDate) {
        this.staffId = staffId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.hiredDate = hiredDate;
    }



    public Employer(String data) {
        Long tempStaffId = null;
        StringBuilder tempName = new StringBuilder();
        Long tempPhoneNumber = null;
        LocalDate tempHiredDate = null;
        List<String> listData = Arrays.stream(data.split(" ")).toList();
        for (String s : listData) {
            if (s.matches("[a-zA-Zа-яА-Я.]+") && s.length() > 1) tempName.append(s).append(' ');
            else if (s.matches("\\bid\\d+")) tempStaffId = Long.parseLong(s.substring(2));
            else if (s.matches("(0[1-9]|[12][0-9]|3[01])[-\\/.](0[1-9]|1[0-2])[-\\/.](19[0-9][0-9]|20[0-9][0-9])"))
                tempHiredDate = getValidLocalData(s);
            else if (s.matches("(\\+?)([8|7|9])([\\(-]?)\\d{3}([\\)-]?)" +
                    "\\d{1}(-?)\\d{1}(-?)\\d{1}(-?)\\d{1}(-?)\\d{1}(-?)\\d{1}(-?)\\d{1}"))
                tempPhoneNumber = getValidPhone(s);
        }
        if (tempStaffId != null && tempName.length() > 0 && tempPhoneNumber != null && tempHiredDate != null) {
            this.staffId = tempStaffId;
            this.name = tempName.toString();
            this.phoneNumber = tempPhoneNumber;
            this.hiredDate = tempHiredDate;
        } else throw new IllegalArgumentException("wrong data");
    }

    // region Getters

    public Long getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    //endregion

    @Override
    public String toString() {
        return "id" + String.format("%04d", staffId)
                + " " + name + "\t" + phoneNumber + "\t" +
                " work since: " + hiredDate.format(formatter);
    }

    private LocalDate getValidLocalData(String stringData) {
        LocalDate localDate = LocalDate.parse(stringData.replaceAll("[-\\/.]", "."), formatter);
        if (localDate.isAfter(LocalDate.now()))
            throw new RuntimeException("Found Data " + stringData + " is not correct!");
        return localDate;
    }

    private Long getValidPhone(String stringData) {
        String digitString = stringData.replaceAll("[\\)\\(-\\/.]", "");
        return Long.parseLong(digitString);
    }
}
