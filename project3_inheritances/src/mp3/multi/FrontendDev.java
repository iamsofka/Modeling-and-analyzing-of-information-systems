package mp3.multi;

import java.time.LocalDate;

import static mp3.Checker.checker;

public class FrontendDev extends Employee implements Designer {

    private Tasks tasks;

    public FrontendDev(String fullName, Tasks tasks) {
        super(fullName);
        setTasks(tasks);
    }

    @Override
    public Tasks getTasks() {
        return tasks;
    }

    @Override
    public void setTasks(Tasks tasks) {
        checker(tasks, this.tasks);
        this.tasks = tasks;
    }

    @Override
    public void workHard() {
        System.out.println("kinda doesn't");
    }
}
