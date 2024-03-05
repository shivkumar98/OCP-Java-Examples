package chapter_7.c_7_1_introducingThreads.java;

public class PrintData implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<3;i++) 
			System.out.println("Printing record: "+i);
	}
	
	public static void main(String[] args) {
		new PrintData().run(); // prints 3 times
		
		new Thread(new PrintData()).start(); // prints 3 times
		
		new Thread(() -> System.out.println("using lambda")).start();
		// prints "using lambda"
	}

}
