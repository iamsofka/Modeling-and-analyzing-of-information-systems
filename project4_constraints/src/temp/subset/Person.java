package temp.subset;

import static temp.Checker.checker;
import static temp.Checker.throwValExp;

public class Person {
    private String name;
    private Department department;
    private Department managedDepartment;

    public Person(String name) {
        setName(name);
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

    public Department getDepartment() {
        if (department == null) {
            throwValExp("Person doesn't have any department assigned");
        }
        return department;
    }

    public void setDepartment(Department department) {
        if (this.department == department){
            return;
        }
        if (department == null){
            throw new IllegalArgumentException("Department is null");
        }
        this.department = department;
        department.addEmployee(this);
    }

    public Department getManagedDepartment() {
        if (managedDepartment == null) {
            throwValExp("person has no managed dept");
        }
        return managedDepartment;
    }

    public void setManagedDepartment(Department managedDepartment) {
        if (department == null){
            throw new IllegalArgumentException("Department is null");
        }
        if (this.managedDepartment == managedDepartment){
            return;
        }
        if (!managedDepartment.getName().equals(department.getName())){
            throwValExp("person cannot manage the department in which he doesn't work");
        }
        checker(managedDepartment, this.managedDepartment);
        this.managedDepartment = managedDepartment;
        department.addManager(this);
    }

    public void removeDepartment(){
        if (department == null){
            throwValExp("person is not in the department");
        } else {
            department.removeEmployee(this);
        }
        if (managedDepartment != null){
            department.removeManager(this);
        }

        managedDepartment = null;
        department = null;
    }

    public void removeManagedDepartment(){
        if (managedDepartment == null){
            throwValExp("person has no managed department");
        }
        department.removeManager(this);
        managedDepartment = null;
    }
}
