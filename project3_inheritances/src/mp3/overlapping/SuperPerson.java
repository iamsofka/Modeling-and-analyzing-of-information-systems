package mp3.overlapping;

import mp3.Checker;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static mp3.Checker.*;


public class SuperPerson implements Actor, Accountant, Engineer, Baker {
    private String fullName;
    private String company;
    private EnumSet<PersonOccupation> occupations = EnumSet.noneOf(PersonOccupation.class);

    private final Set<String> invoices = new HashSet<>();
    private final Set<String> films = new HashSet<>();
    private final Set<String> projects = new HashSet<>();
    private String bakeryType;

    private static final Set<SuperPerson> people = new HashSet<>();

    public SuperPerson(String fullName, String company, EnumSet<PersonOccupation> occupations, String invoice, String film, String project, String bakeryType) {
        setFullName(fullName);
        setCompany(company);
        setOccupations(occupations);

        if (isAccountant()) addInvoice(invoice);

        if (isActor()) addFilm(film);

        if (isBaker()) setBakeryType(bakeryType);

        if (isEngineer()) addProject(project);

        people.add(this);
    }

    private void setOccupations(EnumSet<PersonOccupation> occupations) {
        checker(occupations, this.occupations);
        this.occupations = occupations;
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


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        checker(fullName, this.fullName);
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        checker(company, this.company);
        this.company = company;
    }

    public Set<PersonOccupation> getOccupations() {
        return Collections.unmodifiableSet(occupations);
    }

    public static Set<SuperPerson> getPeople() {
        return Collections.unmodifiableSet(people);
    }

    public boolean isAccountant() {
        return occupations.contains(PersonOccupation.ACCOUNTANT);
    }

    public boolean isEngineer() {
        return occupations.contains(PersonOccupation.ENGINEER);
    }

    public boolean isActor() {
        return occupations.contains(PersonOccupation.ACTOR);
    }

    public boolean isBaker() {
        return occupations.contains(PersonOccupation.BAKER);
    }

    @Override
    public String toString() {
        return "SuperPerson{" +
                "fullName='" + fullName + '\'' +
                ", company='" + company + '\'' +
                ", occupations=" + occupations +
                ", projects=" + projects +
                ", invoices=" + invoices +
                ", films=" + films +
                ", bakeryType='" + bakeryType + '\'' +
                '}';
    }
}
