package headfirst.combining._06_observer;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
