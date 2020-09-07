package headfirst._11_composite;
 
import java.util.Iterator;
  
public class NullIterator implements Iterator<MenuComponent> {
   
	public MenuComponent next() {
		return null;
	}
  
	public boolean hasNext() {
		return false;
	}

}
