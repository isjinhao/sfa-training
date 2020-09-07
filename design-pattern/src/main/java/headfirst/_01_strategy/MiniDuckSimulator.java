package headfirst._01_strategy;

/**
 * Created by Gavin on 2017/2/10.
 */
public class MiniDuckSimulator {
    public static void main(String[] args){
        MallardDuck mallard = new MallardDuck();
        RubberDuck rubberDuck = new RubberDuck();
        DecoyDuck decoy = new DecoyDuck();

        Duck model = new ModelDuck();

        mallard.performQuack();
        rubberDuck.performQuack();
        decoy.performQuack();

        model.performQuack();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
