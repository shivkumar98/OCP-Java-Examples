package chapter_7.c_7_1_introducingThreads.javaCode;

public class ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("Print manga inventory");
	}
	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
	}
}
