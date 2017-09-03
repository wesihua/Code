package producer_consumer;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService_syn extends MyService {
	
	public MyService_syn(int max) {
		super(max);
	}
	
	public void produce(){
		synchronized (list) {
			while(list.size()>0){
				try {
					System.out.println("producer"+Thread.currentThread().getId()+" wait consumer");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			list.add(1);
			System.out.println("producer"+Thread.currentThread().getId()+" produce num");
			list.notifyAll();
		}
	}
	
	public void consume(){
		synchronized (list) {
			while(list.size()==0){
				try {
					System.out.println("consumer"+Thread.currentThread().getId()+" wait producer");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			list.remove(0);
			System.out.println("consumer"+Thread.currentThread().getId()+" consume num");
			list.notifyAll();
		}
	}
}
