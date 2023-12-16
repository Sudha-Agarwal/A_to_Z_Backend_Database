package multithreading;

class SynchronizedSharedResource{
	private int counter = 0;
	private final Object lock = new Object();

	public  void incrementCounter() {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		synchronized (lock) {
			System.out.println("Thread " + Thread.currentThread().getName() + " incrementing");
			this.counter++;
		}		
	}

	public int getCounter() {
		return this.counter;
	}

}
public class SynchronizedMethodExample {
	public static void main(String[] args) {
		SynchronizedSharedResource sharedResouce  = new SynchronizedSharedResource();

		Thread thread1 = new Thread(() -> {
			for(int i=0; i< 5; i++) {
				sharedResouce.incrementCounter();
			}
		});

		Thread thread2 = new Thread(() -> {
			for(int i=0; i< 5; i++) {
				sharedResouce.incrementCounter();
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Final counter value " + sharedResouce.getCounter());




	}

}




