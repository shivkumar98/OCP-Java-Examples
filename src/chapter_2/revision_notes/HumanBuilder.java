package chapter_2.revision_notes;

import java.util.Arrays;
import java.util.List;

public class HumanBuilder {
	private String name;
	private int age;
	private List<String> favoriteFoods;
	public HumanBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public HumanBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public HumanBuilder setFavoriteFoods(List<String> foods) {
		this.favoriteFoods = foods;
		return this;
	}
	public HumanV2 build() {
		return new HumanV2(name, age, favoriteFoods);
	}
	
	public static void main(String[] args) {
		HumanV2 shiv = new HumanBuilder()
				.setAge(25)
				.setName("shiv")
				.setFavoriteFoods(Arrays.asList("pizza","chicken"))
				.build();
		
	}
}

class HumanV2 {
	private String name;
	private int age;
	private List<String> favouriteFoods;
	public HumanV2(String name, int age, List<String> favouriteFoods) {
		this.name = name;
		this.age = age;
		this.favouriteFoods = favouriteFoods;
	}
	
}