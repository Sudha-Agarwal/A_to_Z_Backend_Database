package multithreading;


class NonSynchronizedSharedResource {
	private int counter = 0;
	
	public void incrementCounter() {
		System.out.println("Thread " + Thread.currentThread().getName() + " imcrementing");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.counter++;
	}
	
	public int getCounter() {
		return this.counter;
	}
}
public class NonSynchronizedExample {
	
	public static void main(String[] args) {
		
		NonSynchronizedSharedResource sharedResouce  = new NonSynchronizedSharedResource();
		
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
