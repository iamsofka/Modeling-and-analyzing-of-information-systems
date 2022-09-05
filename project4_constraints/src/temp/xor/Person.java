package temp.xor;

import temp.Checker;

public abstract class Person {
    private String name;
    private Boolean isBookedMeetingRoom;

    public Person(String name, Boolean isBookedMeetingRoom) {
        setBookedMeetingRoom(false);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Checker.checker(name, this.name);
        this.name = name;
    }

    public Boolean getBookedMeetingRoom() {
        return isBookedMeetingRoom;
    }

    public void setBookedMeetingRoom(Boolean bookedMeetingRoom) {
        isBookedMeetingRoom = bookedMeetingRoom;
    }
}
