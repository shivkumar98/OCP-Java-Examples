package chapter_2.revision_notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableGoneWrong {
	public static void main(String[] args) {
		Human shiv = new Human(Arrays.asList("chicken", "falafel"));
		shiv.getFavouriteFoods().add("pizza");
		System.out.println(shiv.getFavouriteFoods()); // [chicken, falafel, pizza]
		// ^Immutability is broken!!!
	}
}


final class Human {
	private final List<String> favouriteFoods;
	public Human(List<String> favouriteFoods) {
		if (favouriteFoods == null)
			throw new RuntimeException("food is required!!!");
		this.favouriteFoods = new ArrayList<String>(favouriteFoods);
	}
	
	public List<String> getFavouriteFoods() {
		return new ArrayList(favouriteFoods);
	}
	
}