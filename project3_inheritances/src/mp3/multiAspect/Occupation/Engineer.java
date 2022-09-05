package mp3.multiAspect.Occupation;

import java.util.Set;

public interface Engineer {
    void addProject(String project);

    void removeProject(String project);

    Set<String> getProject();
}
