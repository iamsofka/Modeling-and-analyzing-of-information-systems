package mp3.multi;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BackendDev backendDev = new BackendDev("name1", "Java", 2);
        FullstackDev fullstackDev = new FullstackDev("name2", "python", 4, backendDev, Tasks.CREATE_NEW_PAGE);

        System.out.println(fullstackDev.getTasks());
        System.out.println(fullstackDev.getBackendDev());
    }
}
