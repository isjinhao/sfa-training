package headfirst.combining._04_factory;

public class GooseAdapter implements Quackable {
	Goose goose;
 
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
  
	@Override
	public void quack() {
		goose.honk();
	}
 
	public String toString() {
		return "Goose pretending to be a Duck";
	}
}
