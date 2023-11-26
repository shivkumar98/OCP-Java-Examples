package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutors {
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			service.execute(
				() -> System.out.println("Begin printing zoo")
			);
			service.execute(
				() -> {for(int i=0;i<3;i++) 
				System.out.println("Printing record "+i);}
			);
			service.execute(
				() -> System.out.println("Finish printing zoo"));
		} finally {
			if(service!=null) service.shutdown();
		}
	}
}
