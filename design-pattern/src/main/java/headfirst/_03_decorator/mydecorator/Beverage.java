package headfirst._03_decorator.mydecorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 2017/3/7.
 */
// 饮料
public abstract class Beverage {

    private List<Condiment> condimentList = new ArrayList<>();

    String description = "Unknown Beverage";

    public void addCondiment(Condiment condiment) {
        condimentList.add(condiment);
    }

    public String getDescription() {
        return description + ", " + condimentDescription();
    }

    protected float condimentCost() {
        float sum = 0f;
        for (Condiment condiment : condimentList) {
            sum += condiment.cost();
        }
        return sum;
    }

    private String condimentDescription() {
        String description = "condiment description: ";

        for(Condiment condiment : condimentList) {
            description = description + condiment.getDescription() + ", ";
        }

        return description.substring(0,  description.lastIndexOf(", ")) + ".";
    }

    public abstract double cost();
}
