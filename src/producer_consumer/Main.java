package producer_consumer;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args){
		MyService myService_syn = new MyService_syn(5);
		MyService myService_lock = new MyService_lock(10);
		Producer[] producers = new Producer[3];
		Consumer[] consumers = new Consumer[3];
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<3;i++){
			producers[i] = new Producer(myService_lock);
			consumers[i] = new Consumer(myService_lock);
		}
		
		for(int i=0;i<3;i++){
			producers[i].start();
			consumers[i].start();
		}
	}
}
