package multithreading;

class Thread1 extends Thread{
	@Override
	public void run() {
		System.out.println("Thread1 is running");
		
		for(int i=0; i< 100; i++) {
			System.out.print(i + " ");
			
		}
		
		System.out.println();
		System.out.println("Thread1 is done");
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread2 is running");
		
		for(int i=100; i< 200; i++) {
			System.out.print(i + "  ");
		}
		
		System.out.println();
		System.out.println("Thread2 is done");
		
	}
	
}

class Thread3 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread3 is running");
		
		for(int i=200; i< 300; i++) {
			System.out.print(i + "  ");
		}
		
		System.out.println();
		System.out.println("Thread3 is done");
		
	}
	
}


public class ThreadRunner {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		
		
		Thread2 thread2 = new Thread2();
		Thread t2 = new Thread(thread2);
		
		Thread thread3 = new Thread(new Thread3());
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread1.start();
		t2.start();
		thread3.start();		
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread thread4 = new Thread(() -> {
			System.out.println("Thread4 is running");
			for(int i=300; i< 400; i++) {
				System.out.print(i + " ");				
			}			
			System.out.println();
			System.out.println("Thread1 is done");
		});
		
		thread4.start();
	
		
		System.out.println("after waiting for thread1 to complete");
		int i =0;
		i++;
		
	}

}
