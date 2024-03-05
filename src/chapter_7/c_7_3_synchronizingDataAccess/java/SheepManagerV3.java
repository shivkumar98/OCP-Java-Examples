package chapter_7.c_7_3_synchronizingDataAccess.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerV3 {
	private int sheepCount = 0;
	private void incrementAndReport() {
		synchronized(this) {
			System.out.print((++sheepCount)+" ");
		}
	}
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(20);
		try {
			SheepManagerV3 manager = new SheepManagerV3();
			for(int i=0;i<10;i++)
				service.submit(() ->manager.incrementAndReport());
		} finally {
			if(service!=null) service.shutdown();
		}
		
	}

}
