package mp3.overlapping;

import java.util.Set;

public interface Engineer {
    void addProject(String project);

    void removeProject(String project);

    Set<String> getProject();
}
