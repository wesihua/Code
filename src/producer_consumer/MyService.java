package producer_consumer;

import java.util.ArrayList;

public abstract class MyService {
	public ArrayList<Integer> list;
	int max;
	
	public MyService(int max) {
		this.max = max;
		list = new ArrayList<>();
	}
	
	public abstract void produce();
	
	public abstract void consume();
}
