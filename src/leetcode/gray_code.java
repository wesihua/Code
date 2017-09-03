package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class gray_code {
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<>();
		if(n==0) {
			result.add(0);
			return result;
		}
		
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(0);
        linkedList.addLast(1);
        
        for(int i=1;i<n;i++) {
        	int size = linkedList.size();
        	for(int j=0;j<size;j++) {
        		String binaryStr = Integer.toBinaryString(linkedList.getFirst());
        		linkedList.removeFirst();
        		if(j%2==0) {
        			linkedList.addLast(Integer.valueOf(binaryStr+"0", 2));
        			linkedList.addLast(Integer.valueOf(binaryStr+"1", 2));
        		}
        		else {
        			linkedList.addLast(Integer.valueOf(binaryStr+"1", 2));
        			linkedList.addLast(Integer.valueOf(binaryStr+"0", 2));
        		}
        	}
        }
        
        result.addAll(linkedList);
        
        return result;
    }
	
	public static void main(String args[]) {
		System.out.println(grayCode(2));
	}
}
