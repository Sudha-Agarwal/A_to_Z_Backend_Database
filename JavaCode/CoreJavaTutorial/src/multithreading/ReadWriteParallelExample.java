package multithreading;

class SharedResource{
	private int data = 0;
	private boolean isWriteInProgress = false;

	public synchronized void readData() {
		while(isWriteInProgress) {
			try {
				//pause the read operation while a write is in progress
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + " is reading data  " + data);
	}

	public synchronized void writeData(int newData) {
		isWriteInProgress = true;

		System.out.println(Thread.currentThread().getName() + " is writing data " + newData);

		try {
			Thread.sleep(1000);
			System.out.println("after sleep");
		}
		catch(InterruptedException e) {
		}
		data = newData;
		isWriteInProgress = false;
		notifyAll();
	}
}
public class ReadWriteParallelExample {
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		
		
		//multiple read threads
		Thread[] readerThreads = new Thread[5];
		
		for(int i=0; i<5; i++) {
			readerThreads[i] = new Thread(() -> {
				resource.readData();			
			});
			readerThreads[i].start();
		}
		
		Thread writeThread = new Thread(() -> {
			resource.writeData(10);	
		});
		//writeThread.setDaemon(true);
		writeThread.start();
	}

}
