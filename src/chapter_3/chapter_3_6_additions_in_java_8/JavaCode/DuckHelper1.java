package chapter_3.chapter_3_6_additions_in_java_8.JavaCode;

public class DuckHelper1 {
	static class Duck {
		String name;
		int weight;
		public Duck(String name, int weight) {
			this.name=name;this.weight=weight;
		}
		public String toString() {
			return "name: "+name+ ", weight: "+weight;
		}
	}
	public static int compareByWeight(Duck d1, Duck d2) {
		return d1.weight - d2.weight;
	}
	public static int compareByName(Duck d1, Duck d2) {
		return d1.name.compareTo(d2.name);
	}
}

 
