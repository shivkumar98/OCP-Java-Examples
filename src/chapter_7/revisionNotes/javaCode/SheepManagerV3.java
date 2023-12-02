package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerV3 {
	int sheepCount = 0;
	void incrementReport() {
		synchronized(this) {
			System.out.print((++sheepCount)+" ");
		}
	}
	public static void main(String[] args) {
		ExecutorService service = null;
		SheepManagerV3 manager = new SheepManagerV3();
		try {
			service = Executors.newFixedThreadPool(20);
			for(int i=0;i<10;i++){
				service.submit(()->manager.incrementReport());
			}
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
