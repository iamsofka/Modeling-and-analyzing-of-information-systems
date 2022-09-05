package mp3.abstra_ct;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static mp3.Checker.*;

public abstract class Item {
    private String name;
    private double price;
    private final Set<Model> models = new HashSet<>();
    private static final Set<Item> availableItems = new HashSet<>();

    public Item(String name, double price, Model material) {
        setName(name);
        setPrice(price);
        models.add(material);
        availableItems.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checker(name, this.name);
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checker(price, this.price);
        this.price = price;
    }

    public Set<Model> getModels() {
        return Collections.unmodifiableSet(models);
    }

    public void addModel(Model model) {
        checkerForAdd(model, models);
        models.add(model);
    }

    public void removeModel(Model model) {
        checkerForRemove(model, models);
        models.add(model);
    }

    public void sell() {
        removeAvailableItem();
    }

    public void removeAvailableItem() {
        availableItems.remove(this);
    }

    public static Set<Item> getAvailableItems() {
        return Collections.unmodifiableSet(availableItems);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", model=" + models +
                '}';
    }
}
