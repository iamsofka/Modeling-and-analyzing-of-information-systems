package mp3.abstra_ct.items;

import mp3.Checker;
import mp3.abstra_ct.Item;
import mp3.abstra_ct.Model;

import static mp3.Checker.checker;

public class Car extends Item {
    private String distributor;
    private int horsePowers;

    public Car(String name, double price, Model model, String distributor, int horsePowers) {
        super(name, price, model);
        setDistributor(distributor);
        setHorsePowers(horsePowers);
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        checker(distributor, this.distributor);
        this.distributor = distributor;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    public void setHorsePowers(int horsePowers) {
        checker(horsePowers, this.horsePowers);
        this.horsePowers = horsePowers;
    }

    @Override
    public void sell() {
        if (getPrice() <= 20000) {
            Checker.throwValExp();
        }
        removeAvailableItem();
    }
}
