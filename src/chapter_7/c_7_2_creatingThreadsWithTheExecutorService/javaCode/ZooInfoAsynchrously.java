package chapter_7.c_7_2_creatingThreadsWithTheExecutorService.javaCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfoAsynchrously {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(
                () -> System
                .out.println("Printing zoo inventory"));
            service.execute(() -> {
                for(int i=0;i<3;i++)
                System.out.println("Printing record: "+i);
                }
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");   
        } finally {
            if(service!=null) service.shutdown();
        }
    }
}
