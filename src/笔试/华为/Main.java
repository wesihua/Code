package 笔试.华为;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main implements Runnable {
	
	HashMap<String, String> map = new HashMap<>();
	int a;
	String s;
	
	public void run() {
		String test = "test";
		String data = map.get(test);
		if(data==null){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (map) {
				if(map.get(test)==null){
					map.put(test, "A");
					data = map.get(test);
				}
			}
		}
		System.out.print(data);
	}

	
	public static void main(String[] args){
		String a = "1";
		String b = "1";
		String c = new String("1");
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(String.format("%s2%s", "dd",null));
			
	}
}
