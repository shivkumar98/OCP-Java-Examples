package chapter_7.c_7_7_identifyingThreadingProblems.javaCode;

import java.util.concurrent.*;
class Food {}
class Water {}

public class Fox {
	String name;

	public Fox(String name) {
		super();
		this.name = name;
	}
	
	public void eatAndDrink(Food food, Water water) {
        synchronized(food) {
            System.out.println(name+" Got Food!");
            move();
            synchronized(water) {
                System.out.println(name+" Got Water!");
            }
        }
    }
    public void drinkAndEat(Food food, Water water) {
        synchronized(water) {
            System.out.println(name+" Got Water!");
            move();
            synchronized(food) {
                System.out.println(name+" Got Food!");
            }
        }
    }
    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
        }
    }
    public static void main(String[] args) {
		Fox foxy = new Fox("foxy");
		Fox tails = new Fox("tails");
		Food food = new Food(); Water water = new Water();

        // Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        } finally {
            if (service!=null) service.shutdown();
        }
	}
	
}
