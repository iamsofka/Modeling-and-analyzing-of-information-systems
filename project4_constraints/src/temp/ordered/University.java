package temp.ordered;

import temp.Checker;

import java.util.*;

public class University {
    private String name;
    private final List<Student> students = new ArrayList<>();

    public University(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Checker.checker(name, this.name);
        this.name = name;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student student){
        if (student == null){
            Checker.throwValExp("student is null");
        }
        if (students.contains(student)){
            Checker.throwValExp("student already exists in the collection");
        }
        students.add(student);
        Collections.sort(students);
    }

    public void removeStudent(Student student){
        if (student == null){
            Checker.throwValExp("student is null");
        }
        if (!students.contains(student)){
            Checker.throwValExp("student already exists in the collection");
        }
        students.remove(student);
        Comparator<Student> compareByAverageGrade = Comparator.comparing(Student::getAverageGrade);
        students.sort(compareByAverageGrade.reversed());
    }

}
