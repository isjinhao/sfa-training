package headfirst._10_iterator;

import java.util.Iterator;

public class Waitress {
	private Menu pancakeHouseMenu;
	private Menu dinerMenu;
 
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
 
	public void printMenu() {
		System.out.println("MENU\n-----------------------------------\nBREAKFAST");
		printMenu(pancakeHouseMenu.createIterator());
		System.out.println("\nLUNCH");
		printMenu(dinerMenu.createIterator());
	}
 
	private void printMenu(Iterator<MenuItem> iterator) {

		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}

	}
 
	public void printVegetarianMenu() {
		System.out.println("Vegetarian MENU\n-----------------------------------\nBREAKFAST");
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		System.out.println("\nLUNCH");
		printVegetarianMenu(dinerMenu.createIterator());
	}

	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName());
				System.out.println("\t\t" + menuItem.getPrice());
				System.out.println("\t" + menuItem.getDescription());
			}
		}
	}

}
