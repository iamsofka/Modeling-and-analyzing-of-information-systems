package mp3.multi;

import java.time.LocalDate;

import static mp3.Checker.checker;

public abstract class Employee {

    private String fullName;

    public Employee(String fullName) {
        setFullName(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        checker(fullName, this.fullName);
        this.fullName = fullName;
    }

    public abstract void workHard();
}
