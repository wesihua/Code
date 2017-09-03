package producer_consumer;

import java.util.ArrayList;

public class Producer extends Thread {
	
	MyService myService;
	
	public Producer(MyService myService) {
		this.myService = myService;
	}
	
	public void run() {
		while(true){
			myService.produce();
		}
	}
	
}
