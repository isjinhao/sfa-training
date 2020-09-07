package headfirst.combining._04_factory;

public class MallardDuck implements Quackable {
 
	@Override
	public void quack() {
		System.out.println("Quack");
	}
 
	public String toString() {
		return "Mallard Duck";
	}
}
