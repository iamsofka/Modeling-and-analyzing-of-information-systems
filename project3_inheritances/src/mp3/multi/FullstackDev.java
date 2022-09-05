package mp3.multi;

import java.time.LocalDate;

import static mp3.Checker.checker;

public class FullstackDev extends BackendDev implements Designer {

    private BackendDev backendDev;
    private Tasks tasks;

    public FullstackDev(String fullName, String language, int experience, BackendDev backendDev, Tasks tasks) {
        super(fullName, language, experience);
        setBackendDev(backendDev);
        setTasks(tasks);
    }

    public BackendDev getBackendDev() {
        return backendDev;
    }

    public void setBackendDev(BackendDev backendDev) {
        checker(backendDev, this.backendDev);
        this.backendDev = backendDev;
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
}
