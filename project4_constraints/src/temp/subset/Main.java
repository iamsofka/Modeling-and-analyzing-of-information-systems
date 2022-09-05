package temp.subset;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Sofiia");
        Person person2 = new Person("name2");
        Department dept1 = new Department("dept1", person1);

        dept1.addEmployee(person2);
        System.out.println(person2.getDepartment().getName());

        person2.setManagedDepartment(dept1);
        System.out.println(person2.getManagedDepartment().getName());

        person2.removeDepartment();
        System.out.println(dept1.getEmployees().size());

        dept1.addManager(person1);
        System.out.println(person1.getDepartment().getName());

        dept1.removeEmployee(person1);
        System.out.println(dept1.getEmployees().size());

        dept1.addEmployee(person1);
        dept1.addManager(person1);
        System.out.println(dept1.getManagers().size());

    }
}
