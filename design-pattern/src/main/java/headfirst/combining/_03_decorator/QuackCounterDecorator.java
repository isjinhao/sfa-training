package headfirst.combining._03_decorator;

public class QuackCounterDecorator implements Quackable {
	Quackable duck;
	static int numberOfQuacks;
  
	public QuackCounterDecorator (Quackable duck) {
		this.duck = duck;
	}
  
	@Override
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
 
	public static int getQuacks() {
		return numberOfQuacks;
	}

	@Override
	public String toString() {
		return duck.toString();
	}
}
