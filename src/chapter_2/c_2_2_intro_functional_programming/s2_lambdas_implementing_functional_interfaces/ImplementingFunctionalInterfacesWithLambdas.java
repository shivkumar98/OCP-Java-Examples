package chapter_2.c_2_2_intro_functional_programming.s2_lambdas_implementing_functional_interfaces;




class Animal {
	private String species; private boolean canHop, canSwin;
	public Animal(String species, boolean canHop, boolean canSwim) {
		this.species = species; this.canHop = canHop; this.canSwin = canSwim;
	}
	public boolean canHop() { return canHop; }
	public boolean canSwim() { return canSwin; }
	public String toString() { return species; }
	
}

interface CheckTrait{
	public boolean test(Animal a);
}
// we shall use lambda expression to create  a program which filters animals on specific attributes
class FindMatchingAnimal{
	public static void print(Animal animal, CheckTrait trait) {
		if (trait.test(animal)) {
			System.out.println(animal);
		}
	}
}

public class ImplementingFunctionalInterfacesWithLambdas {
	public static void main(String[] args) {
		FindMatchingAnimal.print(new Animal("fish", false, true), a -> a.canHop());  
		FindMatchingAnimal.print(new Animal("Kangaroo", true, false), a-> a.canHop()); // Kangaroo
	}
}

// as you can see from above, creating a lambda syntax in place of an interface is quite simple
// since a lambda is passed, Java treats checkTrait as a functional interface