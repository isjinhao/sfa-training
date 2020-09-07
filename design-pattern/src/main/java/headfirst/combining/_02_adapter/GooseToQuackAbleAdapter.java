package headfirst.combining._02_adapter;

public class GooseToQuackAbleAdapter implements Quackable {
	Goose goose;
 
	public GooseToQuackAbleAdapter(Goose goose) {
		this.goose = goose;
	}
 
	@Override
	public void quack() {
		goose.honk();
	}

	@Override
	public String toString() {
		return "Goose pretending to be a Duck";
	}
}
