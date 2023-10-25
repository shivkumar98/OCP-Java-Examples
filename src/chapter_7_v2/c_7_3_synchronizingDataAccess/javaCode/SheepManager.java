package chapter_7.c_7_3_synchronizingDataAccess.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {
	private int sheepCount = 0;
	void incrementAndReport() {
		System.out.print((++sheepCount)+" ");
	}
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			SheepManager manager = new SheepManager();
			service = Executors.newFixedThreadPool(20);
			for(int i=0;i<10;i++)
			service.submit(() -> manager.incrementAndReport());
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
