package revision_notes.javaCode.chapter2;

public class UsingBuilders {
	public static void main(String[] args) {
		AnimalBuilder build = new AnimalBuilder()
		.setAge(1);
		System.out.println(build); 
		// AnimalBuilder [species=null, age=1]
		
		build = build.setSpecies("Monkey");
		System.out.println(build);
		// AnimalBuilder [species=Monkey, age=1]
		
		Animal animal = build.build();
		System.out.println(build);
	}
}

class AnimalBuilder {
	private String species;
	private int age;
	AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public Animal build() {
		return new Animal(species, age);
	}
	public AnimalBuilder setSpecies(String string) {
		this.species = string;
		return this;
	}
	@Override
	public String toString() {
		return "AnimalBuilder [species=" + species + ", age=" + age + "]";
	}
	
}

class Animal {
	private String species;
	private int age;
	public Animal(String species, int age) {
		super();
		this.species = species;
		this.age = age;
	}
	
}