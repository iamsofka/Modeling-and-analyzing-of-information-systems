package mp3.abstra_ct.items;

import mp3.abstra_ct.Item;
import mp3.abstra_ct.Model;

import static mp3.Checker.checker;

public abstract class Assembling extends Item {
    private String name;
    private double assembling;

    public Assembling(String name, double price, Model model, String color, double assembling) {
        super(name, price, model);
        setName(name);
        setAssembling(assembling);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checker(name, this.name);
        this.name = name;
    }

    public double getAssembling() {
        return assembling;
    }

    public void setAssembling(double assembling) {
        checker(assembling, this.assembling);
        this.assembling = assembling;
    }

    public void collect(double duration) {
        setAssembling(getAssembling() - duration);
    }
}
