package chapter_7_v2.c_7_7_identifyingThreadingProblems.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Water {}
class Food {}
public class Fox {
	String name;
	public Fox(String name) { this.name=name; }
	void move() {
		try {
			System.out.println(name+" moving");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// handle exception
		}
	}
    void eatAndDrink(Food food, Water water) {
        synchronized(food) {
            System.out.println(name+" Got Food!");
            move();
            synchronized(water) {
                System.out.println(name+" Got Water!");
            }
        }
    }
    void drinkAndEat(Food food, Water water) {
//        synchronized(water) {
            System.out.println(name+" Got Water!");
            move();
//            synchronized(food) {
                System.out.println(name+" Got Food!");
//            }
//        }
    }
    
    public static void main(String[] args) {
		Fox foxy = new Fox("foxy");
		Fox tails = new Fox("tails");
		Food food = new Food(); Water water = new Water();
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(10);
			service.submit(() -> foxy.eatAndDrink(food, water));
			service.submit(() -> tails.drinkAndEat(food, water));	
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
