package chapter_2.chapter_2_2_intro_functional_programming.s3_ApplyingPredicateInterface;

import java.util.function.Predicate;


class Animal {
	String species; boolean canHop; boolean canSwim;
	public Animal(String species, boolean canHop, boolean canSwim) {
		this.species = species; this.canHop=canHop; this.canSwim=canSwim;
	}
	@Override
	public String toString() {
		return this.species;
	}
}

/* We saw in an earlier example, that we designed a CheckTrait Interface:*/
interface CheckTrait {
	public boolean test(Animal a);
}

class FindAllAnimals{
	static void print(Animal animal, CheckTrait c){
		if (c.test(animal)) { System.out.println(animal); }
	}
}

/* We would need to define alot of interfaces to use lambdas, Java knows this is a common problem and defines an interface for us:
public interface Predicate<T> {
	public boolean test(T t);
}
*/

/* we can write out print method as:
 */
class FindMatchingAnimals {
	static void print(Animal animal, Predicate<Animal> trait) {
		if (trait.test(animal)) { System.out.println(animal);}
	}
}

public class ApplyingPredicateInterface {
	public static void main(String[] args) {
		FindMatchingAnimals.print(new Animal("fish", false, true), a-> a.canHop);
		FindMatchingAnimals.print(new Animal("rabbit", true, false), a->a.canHop); // rabbit
	}
}
