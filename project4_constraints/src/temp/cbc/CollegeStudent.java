package temp.cbc;

import temp.Checker;

import java.util.*;

public class CollegeStudent extends Person{
    private final HashMap<String, Integer> grades = new HashMap<>();
    private JavaKnowledge javaKnowledge;
    private static final Set<CollegeStudent> collegeStudents = new HashSet<>();

    public CollegeStudent(String name, String subject, Integer GPA, JavaKnowledge javaKnowledge) {
        super(name);
        addGPA(subject,GPA);
        setJavaKnowledge(javaKnowledge);
    }

    public Map<String, Integer> getGrades() {
        return Collections.unmodifiableMap(grades);
    }

    public void addGPA(String subject, Integer GPA){
        if (subject == null || GPA == null) {
            Checker.throwValExp("subject or GPA cannot be null");
        }
        if (grades.containsKey(subject)){
            Checker.throwValExp("there is already such subject");
        }
        if (GPA > 5){
            Checker.throwValExp("The GPA cannot be more than 5");
        }
        grades.put(subject, GPA);
    }
    public void removeGPA(String subject){
        if (!grades.containsKey(subject)){
            Checker.throwValExp("there is no such subject in the collection");
        }
        grades.remove(subject);
    }
    public JavaKnowledge getJavaKnowledge() {
        return javaKnowledge;
    }

    public void setJavaKnowledge(JavaKnowledge javaKnowledge) {
        Checker.checker(javaKnowledge, this.javaKnowledge);
        this.javaKnowledge = javaKnowledge;
    }

    public Set<CollegeStudent> getCollegeStudents() {
        return Collections.unmodifiableSet(collegeStudents);
    }
}
