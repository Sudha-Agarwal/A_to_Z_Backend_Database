package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//create a callable task
		Callable<Integer> callabletask = ()->{
			Thread.sleep(2000);
			return 10;
		};
		
		System.out.println("before callable");
		Future<Integer> future = executorService.submit(callabletask);
		
		//perform other tasks to continuw while callable is executing asynchronously
		System.out.println("contunue other work");
		
		boolean isDone = future.isDone();
		try {
			Integer result = future.get();
			System.out.println("result: " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executorService.shutdown();
		System.out.println("after future other work");
		
	}

}
