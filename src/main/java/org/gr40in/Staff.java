package org.gr40in;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Staff {
    private static long idGenerator = 0;
    private List<Employer> employers;

    public void addEmployer(Employer employer) {
        employers.add(employer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Staff: \n");
        for (Employer e : employers) {
            sb.append("\t").append(e).append("\n");
        }
        return sb.toString();
    }

    public Staff() {
        employers = new ArrayList<>();
    }

    public Staff(List<Employer> employers) {
        this.employers = employers;
    }

    public List<Employer> getBySeniority(int years) {
        List<Employer> allFound = new ArrayList<>();
        for (Employer employer : employers)
            if (Period.between(employer.getHiredDate(), LocalDate.now()).getYears() > years) allFound.add(employer);
        return allFound;
    }

    public List<String> getPhoneNumberByName(String partOfTheName) {
        List<String> allFound = new ArrayList<>();
        for (Employer e : employers) {
            if (e.getName().toLowerCase().contains(partOfTheName.toLowerCase())) {
                allFound.add("\t" + e.getName() + " " + e.getPhoneNumber());
            }
        }
        return allFound;
    }

    public Employer getEmployerById(long id) {
        for (Employer e : employers) {
            if (e.getStaffId()==id) return e;
        }
        throw new IllegalArgumentException("Not found this ID");
    }

}
