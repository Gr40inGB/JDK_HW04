package org.gr40in;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Employer {
    private Long staffId;
    private String name;
    private Long phoneNumber;
    private LocalDate hiredDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Employer createEmployer(String data) {

    }

    private Employer(Long staffId, String name, Long phoneNumber, LocalDate hiredDate) {
        this.staffId = staffId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.hiredDate = hiredDate;
    }

    private LocalDate getValidLocalData(String stringData) {

        LocalDate localDate = LocalDate.parse(stringData.replaceAll("[-\\/.]", "."), formatter);
        if (localDate.isAfter(LocalDate.now()))
            throw new RuntimeException("Found Data " + stringData + " is not correct!");
        return localDate;
    }

    private Long getValidPhone(String stringData) {
        String digitString = stringData.replaceAll("[-\\/.]", "");
        return Long.parseLong(digitString);
    }
}
