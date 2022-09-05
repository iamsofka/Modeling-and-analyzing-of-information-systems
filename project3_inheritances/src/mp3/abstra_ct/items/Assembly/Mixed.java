package mp3.abstra_ct.items.Assembly;

import mp3.Checker;
import mp3.abstra_ct.Model;
import mp3.abstra_ct.items.Assembling;

public class Mixed extends Assembling {

    public Mixed(String name, double price, Model model, String color, double assembling) {
        super(name, price, model, color, assembling);
    }

    @Override
    public void collect(double duration) {
        if (getAssembling() <= 0) {
            Checker.throwValExp();
        }
        double g = getAssembling();
        setAssembling(g - duration * 3);
    }
}
