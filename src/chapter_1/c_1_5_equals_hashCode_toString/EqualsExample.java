package chapter_1.c_1_5_equals_hashCode_toString;

public class EqualsExample {
	
	public static void main(String[] args) {
		Zebra zebra = new Zebra(1,2, "zebra 1");
		System.out.println(zebra.equals(new Zebra(1,2, "randomzebra"))); // true
	}

}

 class Zebra {
	private int id;
	int age;
	String name;
	
	public Zebra(int i,int a, String n) {
		id = i; age = a; name = n;
	}
	@Override
	public boolean equals(Object ob) {
		if (!( ob instanceof Zebra)) {
			return false;
		} 
		Zebra zeb = (Zebra)ob;
		return zeb.id == this.id;
	}
}