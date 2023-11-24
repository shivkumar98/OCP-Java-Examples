package chapter_7.revisionNotes.javaCode;

public class CreatingThreads {
	
	public static void main(String[] args) {
		Thread thread = new Thread(
				()->System.out.println("hello")
		);
		thread.run(); // hello
		Printer printer = new Printer();
		printer.start(); // 0 1 2
	}


}

class Printer extends Thread {
	public void run() {
		for(int i=0;i<3;i++)
			System.out.print(i+ " ");
	}
}
