package mp3.multiAspect.Occupation;

import java.util.Set;

public interface Actor {
    void addFilm(String film);

    void removeFilm(String film);

    Set<String> getFilm();
}
