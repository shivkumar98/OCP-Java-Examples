package chapter_1.chapter_1_5_equals_hashCode_toString;
/*
 * All classes inherit from Object
 * We may want to override methods from Object class
 */

public class ToStringExample {
	public static void main(String[] args) {
		ToStringExample string = new ToStringExample();
		System.out.println(string); // ToStringExample@1ee0005
		
		Monkey monkey = new Monkey(120,20);
		System.out.println(monkey); // h: 120, w: 20
	}
}

class Monkey {
	int height;
	int weight;
	public Monkey(int h, int w) {
		height = h; weight = w;

	}
	@Override
	public String toString() {
		return "h: "+height+ ", w: "+weight;
	}
}

