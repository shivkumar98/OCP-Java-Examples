package chapter_2.c_2_5_working_with_design_patterns.s1_applying_the_singleton_pattern.example01;

/* All constructors are labelled private, this implicitly makes the class final 
 * We can not instantiate the below class, nor can we create subclasses which can be instantiated
 * Also all constructors must call super() on first line 
 */
public class HayStorage {
	private int quantity = 0;
	private HayStorage() {}
	
	private static final HayStorage instance = new HayStorage();
	
	public static HayStorage getInstance() {
		return instance;
	}
	
	public synchronized void addHay(int amount) {
		quantity += amount;
	}
	
	public synchronized boolean removeHay (int amount) {
		if (quantity<amount) return false;
		quantity-= amount;
		return true;
	}
	
	public synchronized int getHayQuantity() {
		return quantity;
	}
}

/* Let's see the above singleton in action:*/
class LamaTrainer {
	public boolean feedLamas(int numberOfLamas){
		int amountNeeded = 5*numberOfLamas;
		HayStorage hayStorage = HayStorage.getInstance();
		if (hayStorage.getHayQuantity() < amountNeeded) {
			hayStorage.addHay(amountNeeded+10);
		}
		boolean fed = hayStorage.removeHay(amountNeeded);
		if (fed) System.out.println("Lamas have been fed");
		return fed;
	}
}