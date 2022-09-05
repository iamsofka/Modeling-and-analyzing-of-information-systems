package temp.ordered;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Sofiia", 4.5);
        Student student2 = new Student("Petro", 4.7);
        Student student3 = new Student("Iryna", 4.1);

        University university = new University("PJATK");
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);

        System.out.println(university.getStudents().get(1).getName());

        university.removeStudent(student1);
        System.out.println(university.getStudents().size());
        System.out.println(university.getStudents().get(1).getName());
    }
}
