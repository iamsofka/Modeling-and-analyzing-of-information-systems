package mp3.abstra_ct;

import mp3.abstra_ct.items.Car;
import mp3.abstra_ct.items.Assembling;
import mp3.abstra_ct.items.Assembly.Manual;
import mp3.abstra_ct.items.Assembly.Mixed;
import mp3.abstra_ct.items.Assembly.Machine;

public class Main {
    public static void main(String[] args) {
        Item car = new Car("car1", 41000, Model.VOLVO, "Volvo Warszawa", 123);
        Assembling mixed = new Mixed("car2", 42000, Model.AUDI, "Blue", 100);
        Assembling machine = new Machine("car3", 40000, Model.BMW, "Gray", 100);
        Assembling manual = new Manual("car4", 2000000, Model.BUGATTI, "Yellow", 100);
        System.out.println(Item.getAvailableItems().size());
        car.sell();
        System.out.println(Item.getAvailableItems().size());
        mixed.collect(12);
        machine.collect(12);
        manual.collect(12);
        System.out.println(machine.getAssembling());
        System.out.println(mixed.getAssembling());
        System.out.println(manual.getPrice());
    }
}
