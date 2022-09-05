package mp3.overlapping;

import java.util.Set;

public interface Actor {
    void addFilm(String film);

    void removeFilm(String film);

    Set<String> getFilm();
}
