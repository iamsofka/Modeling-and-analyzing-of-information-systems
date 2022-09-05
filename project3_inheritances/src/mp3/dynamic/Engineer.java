package mp3.dynamic;

import java.util.Set;

public interface Engineer {
    void addProject(String project);

    void removeProject(String project);

    Set<String> getProject();


}
