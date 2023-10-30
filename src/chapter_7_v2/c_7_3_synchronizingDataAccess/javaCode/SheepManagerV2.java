package chapter_7_v2.c_7_3_synchronizingDataAccess.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerV2 {
	private static AtomicInteger sheepCount = new AtomicInteger(0);
    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet()+ " ");
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerV2 manager = new SheepManagerV2();
            for(int i=0;i<10;i++)
                service.submit(() -> manager.incrementAndReport());

        } finally {
            if(service!=null) service.shutdown();
        }
    }

}
