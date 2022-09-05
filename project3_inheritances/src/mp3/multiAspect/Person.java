package mp3.multiAspect;

import mp3.Checker;
import mp3.multiAspect.GenderPackage.Female;
import mp3.multiAspect.GenderPackage.Male;
import mp3.multiAspect.Occupation.*;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static mp3.Checker.*;


public class Person implements Actor, Accountant, Engineer, Baker, Male, Female, Technician {
    private String sphere;
    private Gender gender;
    private PersonOccupation occupation;
    private String fullName;
    private String company;

    private final Set<String> invoices = new HashSet<>();
    private final Set<String> films = new HashSet<>();
    private final Set<String> projects = new HashSet<>();
    private String bakeryType;

    private static final Set<Person> people = new HashSet<>();


    public Person(String fullName, PersonOccupation occupation, Gender gender) {
        if (occupation == PersonOccupation.TECHNICIAN && gender == Gender.FEMALE){
            throw new RuntimeException("Rare job for female, might be a mistake");
        }
        setFullName(fullName);
        setOccupation(occupation);
        setGender(gender);
        people.add(this);
    }

    public PersonOccupation getOccupation() {
        return occupation;
    }

    private void setOccupation(PersonOccupation occupation) {
        checker(occupation, this.occupation);
        this.occupation = occupation;
    }

    public Gender getGender() {
        return gender;
    }

    private void setGender(Gender gender) {
        checker(gender, this.gender);
        this.gender = gender;
    }

    public boolean isAccountant() {
        return occupation.equals(PersonOccupation.ACCOUNTANT);
    }

    public boolean isActor() {
        return occupation.equals(PersonOccupation.ACTOR);
    }

    public boolean isBaker() {
        return occupation.equals(PersonOccupation.BAKER);
    }

    public boolean isEngineer() {
        return occupation.equals(PersonOccupation.ENGINEER);
    }

    public boolean isTechnician() {
        return occupation.equals(PersonOccupation.TECHNICIAN);
    }



    public boolean isMale() {
        return gender.equals(Gender.MALE);
    }

    public boolean isFemale() {
        return gender.equals(Gender.FEMALE);
    }

    public static Set<Person> getPeople() {
        return Collections.unmodifiableSet(people);
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        checker(fullName, this.fullName);
        this.fullName = fullName;
    }

    @Override
    public void PESEL_even() {
        if (!isFemale()){
            Checker.throwValExp();
        }
        System.out.println(this + " has last PESEL digit even");
    }

    @Override
    public void PESEL_odd() {
        if (!isMale()){
            throwValExp();
        }
        System.out.println(this + " has last PESEL digit odd");
    }

    @Override
    public void addProject(String project) {
        if (!isEngineer()) {
            Checker.throwValExp();
        }
        checkerForAdd(project, projects);
        projects.add(project);
    }

    @Override
    public void removeProject(String project) {
        if (!isEngineer()) {
            Checker.throwValExp();
        }
        checkerForRemove(project, projects);
        projects.remove(project);
    }

    @Override
    public Set<String> getProject() {
        if (!isEngineer()) {
            Checker.throwValExp();
        }
        return Collections.unmodifiableSet(projects);
    }

    @Override
    public void addInvoice(String invoice) {
        if (!isAccountant()) {
            Checker.throwValExp();
        }
        checkerForAdd(invoice, invoices);
        invoices.add(invoice);
    }

    @Override
    public void removeInvoice(String invoice) {
        if (!isAccountant()) {
            Checker.throwValExp();
        }
        checkerForRemove(invoice, invoices);
        invoices.remove(invoice);
    }

    @Override
    public Set<String> getInvoices() {
        if (!isAccountant()) {
            Checker.throwValExp();
        }
        return Collections.unmodifiableSet(invoices);
    }

    @Override
    public void addFilm(String film) {
        if (!isActor()) {
            Checker.throwValExp();
        }
        checkerForAdd(film, films);
        films.add(film);
    }

    @Override
    public void removeFilm(String film) {
        if (!isActor()) {
            Checker.throwValExp();
        }
        checkerForRemove(film, films);
        films.remove(film);
    }

    @Override
    public Set<String> getFilm() {
        if (!isActor()) {
            Checker.throwValExp();
        }
        return Collections.unmodifiableSet(films);
    }

    @Override
    public void setBakeryType(String bakeryType) {
        if (!isBaker()) {
            Checker.throwValExp();
        }
        checker(bakeryType, this.bakeryType);
        this.bakeryType = bakeryType;
    }

    @Override
    public String getBakeryType() {
        if (!isBaker()) {
            Checker.throwValExp();
        }
        return bakeryType;
    }

    @Override
    public void setSphere(String rank) {
        if (!isMale() || !isTechnician()){
            throwValExp();
        }
        checker(sphere, this.sphere);
        this.sphere = sphere;
    }

    @Override
    public String getSphere() {
        if (!isMale() || !isTechnician()){
            throwValExp();
        }
        return sphere;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", occupation=" + occupation +
                ", gender=" + gender +
                ", sphere='" + sphere + '\'' +
                ", projects=" + projects +
                ", invoice=" + invoices +
                ", film=" + films +
                ", bakeryType='" + bakeryType + '\'' +
                '}';
    }
}
