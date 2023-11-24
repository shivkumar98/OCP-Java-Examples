package chapter_7.revisionNotes.javaCode;

public class IntroducingRunnable {
	public static void main(String[] args) {
		Runnable r = () ->  System.out.println("hello");
		Runnable r2 = new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		Runnable r3 = () -> {int i=10; i++;}
	}
}
