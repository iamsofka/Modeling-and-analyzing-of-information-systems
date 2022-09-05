package temp.xor;

import temp.Checker;

public class MeetingRoom {
    private String name;
    private int roomNumber;
    private Employee employee;
    private Manager manager;

    public MeetingRoom(String name, int roomNumber) {
        setName(name);
        setRoomNumber(roomNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Checker.checker(name, this.name);
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        Checker.checker(roomNumber, this.roomNumber);
        this.roomNumber = roomNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        if (employee == null) {
            Checker.throwValExp("employee is null");
        }

        if (manager != null){
            Checker.throwValExp("cannot set this meeting room to employee because it is already booked by manager");
        }
        this.employee = employee;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        if (manager == null) {
            Checker.throwValExp("manager is null");
        }
        if (employee != null){
            Checker.throwValExp("cannot set this meeting room to manager because it is already booked by employee");
        }
        this.manager = manager;
    }

    public void freeMeetingRoom(){
        manager = null;
        employee = null;
    }

    public boolean isBookedByManager(){
        return manager != null;
    }

    public boolean isBookedByEmployee(){
        return employee != null;
    }
}
