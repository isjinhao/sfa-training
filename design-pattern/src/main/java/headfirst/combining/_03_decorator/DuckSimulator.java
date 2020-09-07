package headfirst.combining._03_decorator;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}

	void simulate() {
		Quackable mallardDuck = new QuackCounterDecorator(new MallardDuck());
		Quackable redheadDuck = new QuackCounterDecorator(new RedheadDuck());
		Quackable duckCall = new QuackCounterDecorator(new DuckCall());
		Quackable rubberDuck = new QuackCounterDecorator(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose());

		System.out.println("\nDuck Simulator: With Decorator");

		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);

		System.out.println("The ducks quacked " +
			QuackCounterDecorator.getQuacks() + " times");
	}

	void simulate(Quackable duck) {
		duck.quack();
	}
}
