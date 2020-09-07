package headfirst._03_decorator.mydecorator;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public abstract class Condiment {

    private String description;

    public String getDescription() {
        return description;
    }

    public Condiment(String description) {
        this.description = description;
    }

    public abstract float cost();

}
