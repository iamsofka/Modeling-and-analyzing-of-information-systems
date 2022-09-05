package temp.ordered;

import temp.Checker;

public class Student implements Comparable<Student>{
    private String name;
    private Double averageGrade;

    public Student(String name, Double averageGrade) {
        setName(name);
        setAverageGrade(averageGrade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Checker.checker(name, this.name);
        this.name = name;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        Checker.checker(averageGrade, this.averageGrade);
        if (averageGrade > 5){
            Checker.throwValExp("Average grade cannot be more than 5");
        }
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student o) {
        return o.getAverageGrade().compareTo(this.getAverageGrade());
    }
}
