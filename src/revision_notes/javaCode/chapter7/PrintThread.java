package revision_notes.javaCode.chapter7;

public class PrintThread extends Thread {
	@Override
	public void run() {
		System.out.println("running from run");
	}
	public static void main(String[] args) {
		PrintThread pt = new PrintThread();
		new PrintThread().start(); // running from run

	}
}
