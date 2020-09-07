package headfirst.combining._04_factory;

public class DecoyDuck implements Quackable {
 
	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}
 
	public String toString() {
		return "Decoy Duck";
	}
}
