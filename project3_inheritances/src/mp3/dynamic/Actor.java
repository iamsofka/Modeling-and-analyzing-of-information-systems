package mp3.dynamic;

import java.util.Set;

public interface Actor {
    void addFilm(String film);

    void removeFilm(String film);

    Set<String> getFilm();
}
