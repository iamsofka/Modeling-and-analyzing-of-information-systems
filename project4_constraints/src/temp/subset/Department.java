package temp.subset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static temp.Checker.*;

public class Department {
    private String name;
    private final Set<Person> employees = new HashSet<>();
    private final Set<Person> managers = new HashSet<>();

    public Department(String name, Person employee) {
        setName(name);
        addEmployee(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public Set<Person> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public Set<Person> getManagers() {
        return Collections.unmodifiableSet(managers);
    }

    public void addEmployee(Person employee) {
        if (employees.contains(employee)) {
            return;
        }
        checkerForAddAndRemove(employee, employees);
        employees.add(employee);
        employee.setDepartment(this);
    }

    public void addManager(Person manager){
        checkerForAddAndRemove(manager, managers);
        if (manager.getDepartment() == null){
            throwValExp("Person doesn't have any department assigned");
        }
        employees.add(manager);
        managers.add(manager);
        if (managers.contains(manager)){
            return;
        }
        manager.setManagedDepartment(this);
    }

    public void removeEmployee(Person employee) {
        if (!employees.contains(employee)){
            return;
        }
        checkerForAddAndRemove(employee, employees);
        employees.remove(employee);
        managers.remove(employee);

        employee.removeDepartment();
    }

    public void removeManager(Person manager){
        if (!managers.contains(manager)){
            return;
        }
        checkerForAddAndRemove(manager, managers);
        managers.remove(manager);
        if (manager.getManagedDepartment() != null){
            return;
        }
        manager.removeManagedDepartment();
    }
}
