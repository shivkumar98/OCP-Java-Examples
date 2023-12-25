package revision_notes.javaCode.chapter7;

public class UsingThreadSleep {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("before sleep");
		Thread.sleep(1000);
		System.out.println("after sleep");
	}
}
