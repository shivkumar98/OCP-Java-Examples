package chapter_7.c_7_1_introducingThreads.javaCode;

public class Concurrency {
	public static void main(String[] args) {
//		System.out.println("begin");
//		(new ReadInventoryThread()).start();
//		(new Thread(new PrintData())).start();
//		(new ReadInventoryThread()).start();
//		System.out.println("end");
		
		System.out.println("start");
		new PrintData().run();
		(new Thread(new PrintData())).run();
		(new ReadInventoryThread()).run();
		System.out.println("end");
	}
}

class PrintData implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<3;i++)
			System.out.println("Printing record: "+i);
	}
}

class ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("Printing zoo inventory");
	}
}