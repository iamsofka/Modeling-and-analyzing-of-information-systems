package temp.bag;

import java.util.*;

public class Test {

    private String name;
    private Integer grade;

    private Student student;
    private Subject subject;

    private static Set<Test> test = new HashSet<>();

    public Test (String name, Integer grade){
        this.name = name;
        this.grade = grade;

        test.add(this);
    }

    public String getName() {
        return name;
    }

    public Integer getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setGrade(Integer grade) {
        if (grade == null || grade <= 2){
            throw new IllegalArgumentException("Grade cannot be null or less than 2");
        }
        this.grade = grade;
    }

    public void setStudent(Student student) {
        if (student == null){
            throw new IllegalArgumentException("Student can't be null");
        }
        this.student = student;
        this.student.addTest(this);
    }

    public void setSubject(Subject subject) {
        if (subject == null){
            throw new IllegalArgumentException("Subject can't be null");
        }
        this.subject = subject;
        this.subject.addTest(this);
    }

    public void removeTest() {
        if (this.subject != null){
            Subject tmp = this.subject;
            this.subject = null;
            tmp.deleteTest(this);
        }
        if (this.student != null){
            Student tmp = this.student;
            this.student = null;
            tmp.deleteTest(this);
        }
    }
}
