package temp.cbc;

import temp.Checker;

public abstract class Person {
    private String name;

    public Person(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Checker.checker(name, this.name);
        this.name = name;
    }
}
