package mp3.dynamic;

import mp3.Checker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static mp3.Checker.*;


public class Person implements Actor, Accountant, Engineer, Baker {
    private String fullName;
    private String company;
    private PersonOccupation occupation;

    private final Set<String> invoices = new HashSet<>();
    private final Set<String> films = new HashSet<>();
    private final Set<String> projects = new HashSet<>();
    private String bakeryType;

    private static final Set<Person> people = new HashSet<>();

    public Person(String fullName, String company, PersonOccupation occupation, String invoice, String film, String project, String bakeryType) {
        setFullName(fullName);
        setCompany(company);
        setOccupation(occupation);

        if (isActor()) addInvoice(invoice);

        else if (isActor()) addFilm(film);

        else if (isBaker()) setBakeryType(bakeryType);

        else if (isEngineer()) addProject(project);

        people.add(this);
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

    public PersonOccupation getOccupation() {
        return occupation;
    }

    public void setOccupation(PersonOccupation occupation) {
        checker(occupation, this.occupation);
        this.occupation = occupation;
    }

    public static Set<Person> getPeople() {
        return Collections.unmodifiableSet(people);
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


    public void becomeAccountant(String invoice) {
        Checker.isNull(invoice);
        if (isAccountant()) {
            Checker.throwValExp();
        }
        cleaner();

        setOccupation(PersonOccupation.ACCOUNTANT);
        addInvoice(invoice);
    }

    public void becomeActor(String film) {
        Checker.isNull(film);
        if (isActor()) {
            Checker.throwValExp();
        }
        cleaner();

        setOccupation(PersonOccupation.ACTOR);
        addProject(film);
    }

    public void becomeBaker(String bakeryType) {
        Checker.isNull(bakeryType);
        if (isBaker()) {
            Checker.throwValExp();
        }
        cleaner();

        setOccupation(PersonOccupation.BAKER);
        this.bakeryType = bakeryType;
    }

    public void becomeEngineer(String project) {
        Checker.isNull(project);
        if (isEngineer()) {
            Checker.throwValExp();
        }
        cleaner();

        setOccupation(PersonOccupation.ENGINEER);
        addProject(project);
    }

    public void cleaner() {
        this.invoices.clear();
        this.films.clear();
        this.projects.clear();
        this.bakeryType = null;
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
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + company + '\'' +
                ", occupation=" + occupation +
                ", invoices=" + invoices +
                ", films=" + films +
                ", projects=" + projects +
                ", bakeryType='" + bakeryType + '\'' +
                '}';
    }
}
