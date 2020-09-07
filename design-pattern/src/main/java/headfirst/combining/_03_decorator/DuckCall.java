package headfirst.combining._03_decorator;

public class DuckCall implements Quackable {
 
	@Override
	public void quack() {
		System.out.println("Kwak");
	}
 
	public String toString() {
		return "Duck Call";
	}
}
