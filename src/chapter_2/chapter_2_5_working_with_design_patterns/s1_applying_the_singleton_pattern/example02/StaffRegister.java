package chapter_2.chapter_2_5_working_with_design_patterns.s1_applying_the_singleton_pattern.example02;

/* A singleton was instantiated via a static field 
 * We can also instantiate singleton through static initialiser:
 */

public class StaffRegister {
	private static final StaffRegister instance;
	static {
		instance = new StaffRegister();
	}
	private StaffRegister() {}
	public static StaffRegister getInstance() {
		return instance;
	}
}
