package headfirst.combining._03_decorator;

public class MallardDuck implements Quackable {
 
	@Override
	public void quack() {
		System.out.println("Quack");
	}
 
	public String toString() {
		return "Mallard Duck";
	}
}
