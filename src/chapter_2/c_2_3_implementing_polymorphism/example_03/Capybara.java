package chapter_2.c_2_3_implementing_polymorphism.example_03;

/* Even if two classes share a hierarchy, casting still may be unlikely to occur without issues
 * For example, you cannot cast a super class to its subclass without ClassCastException
 */

class Rodent { }

public class Capybara extends Rodent {
	public static void main(String[] args) {
		Rodent rodent = new Rodent();
		// Capybara capybara = (Capybara)rodent; // causes class cast exception
		
		// we should use the instanceof operator before casting:
		if (rodent instanceof Capybara) {
			Capybara capybara = (Capybara) rodent;
		}
	}
}
