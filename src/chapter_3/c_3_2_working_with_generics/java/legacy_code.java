package chapter_3.c_3_2_working_with_generics.java;

import java.util.ArrayList;
import java.util.List;

class Dragon{}
class Unicorn{}

public class legacy_code {
	
	private static void printDragons(List<Dragon> dragons) {
		for (Dragon dragon: dragons) {
			System.out.println(dragon);
		}
	}
	
	public static void main(String[] args) {
		List unicorns = new ArrayList();
		unicorns.add(new Unicorn());
		printDragons(unicorns);
	}
}

