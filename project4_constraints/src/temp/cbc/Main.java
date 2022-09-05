package temp.cbc;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> student1 = new HashMap<>();
        student1.put("Calculus", 5);

        CollegeStudent collegeStudent1 = new CollegeStudent("Sofiia1" , "Calculus", 5, JavaKnowledge.INTERMEDIATE);
        collegeStudent1.addGPA("Programming", 4);
        collegeStudent1.addGPA("Physics", 4);
        collegeStudent1.addGPA("English", 5);

        //CollegeStudent collegeStudent2 = new CollegeStudent("Sofiia2" , "Physics", 5, JavaKnowledge.ADVANCED);


        University university = new University("PJATK");
        university.addStudent(collegeStudent1);
        //university.addStudent(collegeStudent2);

        System.out.println(university.getStudents().size());
    }

}
