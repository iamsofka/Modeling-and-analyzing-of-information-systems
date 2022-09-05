package temp.xor;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Sofiia1");
        Employee employee2 = new Employee("Sofiia2");

        Manager manager1 = new Manager("Manager1");
        Manager manager2 = new Manager("Manager2");

        MeetingRoom meetingRoom = new MeetingRoom("Zamosc", 434);

        employee1.bookedMeetingRoom(meetingRoom);

        System.out.println(meetingRoom.getEmployee());

        manager2.bookedMeetingRoom(meetingRoom);
    }

}
