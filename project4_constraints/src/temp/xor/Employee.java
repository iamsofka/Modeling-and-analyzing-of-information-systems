package temp.xor;

import temp.Checker;

public class Employee extends Person {
    private static Boolean isBookedMeetingRoom = false;

    public Employee(String name) {
        super(name, isBookedMeetingRoom);
    }

    public void bookedMeetingRoom(MeetingRoom meetingRoom){
        if (meetingRoom.isBookedByManager()){
            Checker.throwValExp("this meeting room is already booked by manager");
        }
        isBookedMeetingRoom = true;
        meetingRoom.setEmployee(this);
    }
}
