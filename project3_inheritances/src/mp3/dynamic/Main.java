package mp3.dynamic;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("name1", "company1",
                PersonOccupation.ACCOUNTANT, "inv34597", "film1", "proj1", "cake");

        //person.becomeEngineer("project");
        //person.becomeActor("film2");
        person.addInvoice("asdf");

    }
}
