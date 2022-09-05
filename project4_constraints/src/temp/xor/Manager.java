package temp.xor;

import temp.Checker;

public class Manager extends Person{
    private static Boolean isBookedMeetingRoom = false;

    public Manager(String name) {
        super(name, isBookedMeetingRoom);
    }

    public void bookedMeetingRoom(MeetingRoom meetingRoom){
        if (meetingRoom.isBookedByEmployee()){
            Checker.throwValExp("this meeting room is already booked by employee");
        }
        isBookedMeetingRoom = true;
        meetingRoom.setManager(this);
    }
}
