package mp3.multi;

import mp3.Checker;

import java.time.LocalDate;

public class BackendDev extends Employee {
    private String language;
    private int experience;

    public BackendDev(String fullName, String language, int experience) {
        super(fullName);
        setLanguage(language);
        setExperience(experience);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        Checker.checker(language, this.language);
        this.language = language;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        Checker.checker(experience, this.experience);
        this.experience = experience;
    }

    @Override
    public void workHard() {
        System.out.println("more yes than no");
    }

    @Override
    public String toString() {
        return "Human{" +
                "language='" + language + '\'' +
                ", experience in years='" + experience + '\'' +
                '}';
    }
}
