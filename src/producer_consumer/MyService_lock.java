package producer_consumer;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService_lock extends MyService{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public MyService_lock(int max) {
		super(max);
	}
	
	public void produce(){
		try {
			lock.lock();
			while(list.size()==max){
				System.out.println("producer"+Thread.currentThread().getId()+" wait consumer");
				condition.await();
			}
			list.add(1);
			System.out.println("producer"+Thread.currentThread().getId()+" produce num");
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void consume(){
		try {
			lock.lock();
			while(list.size()==0){
				System.out.println("consumer"+Thread.currentThread().getId()+" wait producer");
				condition.await();
			}
			list.remove(0);
			System.out.println("consumer"+Thread.currentThread().getId()+" consume num");
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

}
