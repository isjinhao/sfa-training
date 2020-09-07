package headfirst._06_command.diner;

/**
 * @author 01395265
 */
public class Customer {

	Waitress waitress;
	Order order;

	public Customer(Waitress waitress) {
		this.waitress = waitress;
	}

	public void createOrder(Order order) {
		this.order = order;
	}

	public void hungry() {
		waitress.takeOrder(order);
	}

}