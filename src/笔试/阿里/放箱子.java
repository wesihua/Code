package 笔试.阿里;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 放箱子 {
	
	public static void main(String args[]){
	        Scanner scanner = new Scanner(System.in);
	        int length = scanner.nextInt();
	        int width = scanner.nextInt();
	        int height = scanner.nextInt();
	        int size = length*width*height;
	        
	        int n = scanner.nextInt();
	        List<Box> list = new ArrayList<>();
	        int flag = 0;
	        for(int i=0;i<n;i++) {
	        	int price = scanner.nextInt();
	        	if(price>2000)
	        		flag = -1;
	        	int length_ = scanner.nextInt();
	        	int width_ = scanner.nextInt();
	        	int height_ = scanner.nextInt();
	        	if(!check(length, width, height, length_, width_, height_))
	        		flag = -1;
	        	list.add(new Box(price,length_,width_,height_));
	        }
	        
	        if(flag==-1)
	        	System.out.println(-1);
	        else {
	        	Collections.sort(list, new Comparator<Box>() {
					@Override
					public int compare(Box o1, Box o2) {
						// TODO Auto-generated method stub
						return o2.size-o1.size;
					}
		        });
	        	
	        	int result = 0;
	        	while(list.size()>0) {
	        		Box box = list.get(0);
	        		list.remove(0);
	        		int sumSize = box.size;
	        		int sumPrice = box.price;
	        		
	        		for(int i=0;i<list.size();) {
        				if(sumSize+list.get(i).size<size && sumPrice+list.get(i).price<=2000) {
        					sumSize += list.get(i).size;
        					sumPrice += list.get(i).price;
        					list.remove(i);
        				}
        				else
        					i++;
        			}
	        		
	        		result++;
	        	}
	        	
	        	System.out.println(result);
	        }
	}
	
	public static boolean check(int length,int width,int height,int length_,int width_,int height_ ) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list_ = new ArrayList<>();
		
		list.add(length);
		list.add(width);
		list.add(height);
		Collections.sort(list);
		
		list_.add(length_);
		list_.add(width_);
		list_.add(height_);
		Collections.sort(list_);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i)<list_.get(i)) {
				return false;
			}
		}
		
		return true;
	}
}

class Box {
	int price;
	int length;
	int width;
	int height;
	int size;
	
	Box(int price,int length,int width,int height){
		this.price = price;
		this.length = length;
		this.width = width;
		this.height = height;
		size = length*width*height;
	}
}
