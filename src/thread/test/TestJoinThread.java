package thread.test;

public class TestJoinThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("thread start");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread end");
	}
	
	public static void main(String[] args) throws InterruptedException{
		System.out.println("main start");
		TestJoinThread testJoinThread = new TestJoinThread();
		testJoinThread.start();
		testJoinThread.join(10000);
		System.out.println("main end");
	}
	
	
}
