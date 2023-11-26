package chapter_7.revisionNotes.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitingForTasksToFinish {
    static long limit = 1_000_000_000_000L;
    public static void main(String[] args) throws InterruptedException {
	   ExecutorService service = null;
	    try {
	    	service = Executors.newSingleThreadExecutor();
	    
			for(long i=0;i<limit;i++)
				service.submit(()-> 1);
	    				
	    	
	    } finally {
	    	if(service!=null) service.shutdown();
	    }
	    if (service!=null) {
	    	service.awaitTermination(1, TimeUnit.MINUTES);
	    	if (service.isTerminated())
	    		System.out.println("terminated successfully");
	    	else
	    		System.out.println("at least one task is still running");
	    }
	}
 
}
