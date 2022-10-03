package chapter_2.chapter_2_1.designing_an_interface.example03;

import java.util.List;

/* we can use interfaces to mock objects*/
public class Animal {}
class Tortoise extends Animal {}
class Hare extends Animal {}
interface RaceManager {
	public Animal getWinner(List<Animal> animals);
}

/* we can mock an implementation of RaceManager */
class DummyRaceManager implements RaceManager{
	public Animal getWinner(List<Animal> animals) {
		return animals==null || animals.size()==0 ? null : animals.get(0);
	}
}
