package test;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class thread_test {
	Thread thread;
	ThreadPoolExecutor threadPoolExecutor;
	FutureTask<Integer> futureTask;
	
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				Thread.sleep(1000);
				return 1;
			}
		};
		
		FutureTask<Integer> futureTask = new FutureTask<>(callable);
		Thread thread = new Thread(futureTask);
//		futureTask.run();
		thread.start();
		System.out.println("????");
		System.out.println(futureTask.get());
		
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		HashMap<String, String> map = new HashMap<>();
		
		ReentrantLock lock = new ReentrantLock();
	}
}
