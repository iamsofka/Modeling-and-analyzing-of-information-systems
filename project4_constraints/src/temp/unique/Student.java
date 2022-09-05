package temp.unique;

import jdk.jshell.Snippet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static temp.Checker.checker;
import static temp.Checker.throwValExp;

public class Student {
    private String name;
    private String university;
    private String sNumber;
    private static final HashMap<Long, Student> students = new HashMap<>();

    public Student(String name, String university, String sNumber) {
        setName(name);
        setUniversity(university);
        setsNumber(sNumber);
        students.get(sNumber);
    }

    public Student getStudentByID(String sNumber) {
        if (sNumber == null || sNumber.isEmpty()){
            throw new IllegalArgumentException("Student number cannot be null or empty");
        }
        return students.get(sNumber);
    }

    public static Map<Long, Student> getStudents() {
        return Collections.unmodifiableMap(students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        if (university == null || university.isEmpty()){
            throw new IllegalArgumentException("University name cannot be null or empty");
        }
        this.university = university;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        if (sNumber == null || sNumber.isEmpty()){
            throw new IllegalArgumentException("Student number cannot be null or empty");
        }
        if (students.containsKey(sNumber)){
            throwValExp("Student already exists");
        }
        this.sNumber = sNumber;
    }

    public void removeStudentBySNumber(String sNumber){
        if (sNumber == null || sNumber.isEmpty()){
            throw new IllegalArgumentException("Student number cannot be null or empty");
        }
        students.remove(sNumber);
    }
}
