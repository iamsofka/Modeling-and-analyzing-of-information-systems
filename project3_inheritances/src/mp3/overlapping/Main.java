package mp3.overlapping;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {

        EnumSet<PersonOccupation> occupations = EnumSet.of(PersonOccupation.ACCOUNTANT);
        occupations.add(PersonOccupation.ACTOR);

        SuperPerson person = new SuperPerson("name1", "company1",
                occupations, "inv3485", "film", "proj", "");

        System.out.println(person.getOccupations().size());
//        person.addClient("client");
        person.addInvoice("project1");
        System.out.println(person.getOccupations().size());
        person.addInvoice("asdf");

    }
}
