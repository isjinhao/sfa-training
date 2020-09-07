package headfirst._06_command.diner;

public class BurgerAndFriesOrder implements Order {
	Cook cook;
	public BurgerAndFriesOrder(Cook cook) {
		this.cook = cook;
	}
	@Override
	public void orderUp() {
		cook.makeBurger();
		cook.makeFries();
	}
}
