package chapter_1.chapter_1_5_equals_hashCode_toString;

import java.util.Objects;

public class EqualsExample2 {
	public static void main(String[] args) {
		Lion lion1 = new Lion(1, "shiv");
		Lion lion2 = new Lion(1,"shiv");
		System.out.println(lion1.equals(lion2));
	}
}

class Lion {
	private int age;
	private String name;

	public Lion(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Lion)) return false;
		Lion other = (Lion) obj;
		return age == other.age && name.equals(other.name);
	}
	
}