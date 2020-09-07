package headfirst.combining._04_factory;

public class RubberDuck implements Quackable {
 
	@Override
	public void quack() {
		System.out.println("Squeak");
	}
  
	public String toString() {
		return "Rubber Duck";
	}
}
