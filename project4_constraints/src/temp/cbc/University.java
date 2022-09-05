package temp.cbc;

import temp.Checker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class University {
    private String name;
    private final Set<Student> students = new HashSet<>();

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

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public void addStudent(CollegeStudent collegeStudent){
        if (collegeStudent == null){
            Checker.throwValExp("school child is null");
        }

        if (collegeStudent.getJavaKnowledge() == JavaKnowledge.ENTRY ||
                collegeStudent.getJavaKnowledge() == JavaKnowledge.BEGINNER){
            Checker.throwValExp("Student's Java knowledge is too low");
        }
        if (!collegeStudent.getGrades().containsKey("Calculus")){
            Checker.throwValExp("Calculus is missing");
        }
        if (!collegeStudent.getGrades().containsKey("Programming")){
            Checker.throwValExp("Programming is missing");
        }
        if (!collegeStudent.getGrades().containsKey("English")){
            Checker.throwValExp("Electronics is missing");
        }
        if (!collegeStudent.getGrades().containsKey("Physics")){
            Checker.throwValExp("Physics is missing");
        }


        if(collegeStudent.getGrades().get("Calculus") < 4){
            Checker.throwValExp("in order to enter this University - school child has to have grade for calculus more or equal 4");
        }
        if (collegeStudent.getGrades().get("Programming") < 4){
            Checker.throwValExp("in order to enter this University - school child has to have grade for programming more or equal 4");
        }
        if (collegeStudent.getGrades().get("English") < 3){
            Checker.throwValExp("in order to enter this University - school child has to have grade for English more or equal 3");
        }
        if (collegeStudent.getGrades().get("Physics") < 3){
            Checker.throwValExp("in order to enter this University - school child has to have grade for physics more or equal 3");
        }


        Student student = new Student(collegeStudent.getName());
        students.add(student);
    }

    public void removeStudent(Student student){
        Checker.checkerForAddAndRemove(student, students);
        students.remove(student);
    }
}
