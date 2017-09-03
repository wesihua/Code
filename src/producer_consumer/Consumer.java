package producer_consumer;

import java.util.ArrayList;

public class Consumer extends Thread {
	
	MyService myService;
	
	public Consumer(MyService myService) {
		this.myService = myService;
	}
	
	public void run() {
		while(true){
			myService.consume();
		}
	}
	
}
