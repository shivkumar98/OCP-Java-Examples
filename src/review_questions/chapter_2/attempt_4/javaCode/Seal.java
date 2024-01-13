package review_questions.chapter_2.attempt_4.javaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seal {

	private final String name;
	private final List<Seal> friends;
	
	public Seal(String name, List<Seal> friends) {
		this.name = name;
		this.friends = friends;
	}
	public String getName() {
		return name;
	}
	public List<Seal> getFriends() {
		return new ArrayList(friends);
	}
	
	private class IllegalSeal extends Seal {

		public IllegalSeal(String name, List<Seal> friends) {
			super(name, friends);		
		}
		
		public List<Seal> getFriends() {
			return friends;
		}
		
	}
	public static void main(String[] args) {
		IllegalSeal seal = new IllegalSeal("shiv", null);
	}
}
