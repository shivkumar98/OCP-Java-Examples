package chapter_7_v2.c_7_3_synchronizingDataAccess.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {
	private int sheepCount = 0;
	 void incrementAndReport() {
		System.out.println((++sheepCount) + " ");
	}
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			for(int i=0;i<10;i++)
				service.submit(() -> manager.incrementAndReport());
		} finally {
			if(service!=null) service.shutdown();
		}
	}

}


