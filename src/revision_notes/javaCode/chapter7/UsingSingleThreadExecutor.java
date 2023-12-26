package revision_notes.javaCode.chapter7;

import java.security.Provider.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadExecutor {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = null;
		try {
		service = Executors.newFixedThreadPool(10);
		service.execute(()->{System.out.println("begin");});
		service.execute(()-> {for(int i=0;i<5;i++) {
			if (i==1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			}
		});
		service.execute(()->{for (int i=10;i<31;i++) {
			System.out.println(i);
		}});
		service.execute(()->System.out.println("end"));
		} finally {
			service.shutdown();
		}
	}
}
