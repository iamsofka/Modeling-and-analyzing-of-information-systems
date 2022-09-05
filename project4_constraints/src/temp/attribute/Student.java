package temp.attribute;

import static temp.Checker.checker;
import static temp.Checker.throwValExp;

public class Student {
    private String name;
    private Integer numberOfSubjects = 0;
    private int yearOfStudy;

    private static final Integer minNumberOfSubjects = 3;
    private static final Integer maxNumberOfSubjects = 51;

    public Student(String name, Integer numberOfSubjects, int yearOfStudy) {
        setName(name);
        setNumberOfSubjects(numberOfSubjects);
        setYearOfStudy(yearOfStudy);
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        checker(yearOfStudy, this.yearOfStudy);
        this.yearOfStudy = yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checker(name, this.name);
        this.name = name;
    }

    public Integer getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(Integer numberOfSubjects) {
        checker(numberOfSubjects, this.numberOfSubjects);

        if (numberOfSubjects > maxNumberOfSubjects || numberOfSubjects < minNumberOfSubjects){
            throwValExp("Number of subjects cannot be less that " + minNumberOfSubjects + " and more than " + maxNumberOfSubjects);
        }
        this.numberOfSubjects = numberOfSubjects;
    }
}
