package temp.bag;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static temp.Checker.*;

public class Subject {
    private String name;
    private static Set<Subject> subjects = new HashSet<>();
    private Set<Test> tests;

    public Subject(String name) {
       this.name = name;

        subjects.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checker(name, this.name);
        this.name = name;
    }

    public Set<Test> getTest(){
        return Collections.unmodifiableSet(tests);
    }

    public void addTest(Test test) {
        if (test == null){
            throw new IllegalArgumentException("Test is null");
        }
        if (test.getSubject() == null){
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
