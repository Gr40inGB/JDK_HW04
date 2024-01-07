package org.gr40in;

import java.util.List;

public class Main<T> {
    public static void main(String[] args) {
        Staff staff = new Staff();

        staff.addEmployer(new Employer("id001 H.LAURIE HOUSE 8-937-4644646 11-11-2005"));
        staff.addEmployer(new Employer("id002 TAYLOR SWIFT  7(927)066-65-61 22.06.2013"));
        staff.addEmployer(new Employer("id003 MR.BEAST blog  7(927)144-58-79 29.11.2004"));
        staff.addEmployer(new Employer("id004 JUSTIN BIEBER  7(927)183-92-60 13.04.2015"));
        staff.addEmployer(new Employer("id005 ARIANA GRANDE  7(927)279-74-13 26.06.2022"));
        staff.addEmployer(new Employer("id006 MILLIE B.BROWN 7(927)572-34-27 06.03.2023"));
        staff.addEmployer(new Employer("id007 BILLIE EILISH  7(927)183-92-60 18.12.2009"));
        staff.addEmployer(new Employer("id008 MATTHEW PERRY  7(927)572-34-27 06.11.2022"));
        staff.addEmployer(new Employer("id009 JENNA ORTEGA  7(927)105-14-63 28.06.2005"));
        staff.addEmployer(new Employer("id010 ZENDAYA BEAUTY 7(927)066-65-61 16.07.2014"));
        staff.addEmployer(new Employer("id011 TOM HOLLAND Jun 7(927)925-53-82 05.07.2022"));

//        System.out.println(staff);

        staff.getBySeniority(6).forEach(System.out::println);
        System.out.println("\nsearch by name: (bi)\n");
        staff.getPhoneNumberByName("bi").forEach(System.out::println);

        System.out.println("\nsearch employer by id: (10)\n");
        System.out.println("\t" + staff.getEmployerById(10));
    }

}