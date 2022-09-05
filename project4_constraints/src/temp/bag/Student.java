package temp.bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static temp.Checker.checker;

public class Student {
    private String name;
    private String sNumber;
    private Subject subject;
    private static final Set<Student> students = new HashSet<>();

    private Set<Test> tests;

    public Student(String name, String sNumber) {
        this.name = name;
        this.sNumber = sNumber;
        students.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checker(name, this.name);
        this.name = name;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        checker(sNumber, this.sNumber);
        this.sNumber = sNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public static Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public Set<Test> getTest(){
        return Collections.unmodifiableSet(tests);
    }

    public void addTest(Test test) {
        if (test == null){
            throw new IllegalArgumentException("Test is null");
        }
        if (test.getStudent() == null){
            throw new IllegalArgumentException("invalid test");
        }
        this.tests.add(test);
    }

    public void deleteTest(Test test) {
        if (this.tests.contains(test)){
            this.tests.remove(test);
            test.removeTest();
        }
    }
}
