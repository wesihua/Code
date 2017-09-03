package 剑指offer;

import java.util.ArrayList;
import java.util.*;

public class 丑数 {
	public static int GetUglyNumber_Solution(int index) {
        if(index<0)
        	return 0;
		if(index==1)
        	return 1;
        
		Integer[] d = {2,3,5};
        Integer[] t = {0,0,0};
        Integer[] temp = {0,0,0};
        int[] array = new int[index];
        array[0] = 1;
        
        int currIndex = 0;
        while(true){
        	for(int i=0;i<3;i++){
            	for(int j=t[i];j<=currIndex;j++){
            		if(d[i]*array[j]>array[currIndex]){
            			temp[i] = d[i]*array[j];
            			t[i] = j;
            			break;
            		}
            	}
            }
        	//list.add(Math.min(temp[0], Math.min(temp[1], temp[2])));
        	//System.out.println(list);
//        	for(int i=0;i<=currIndex;i++){
//        		System.out.print(array[i]+" ");
//        	}
//        	System.out.println();
        	
        	array[++currIndex] = Math.min(temp[0], Math.min(temp[1], temp[2]));
        	if(currIndex==index-1)
        		break;
        }
        
        return array[currIndex];
    }
	
	public int FirstNotRepeatingChar(String str) {
		if(str.equals(""))
			return -1;
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==null)
                map.put(str.charAt(i),1);
            else{
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
        }
        
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }
        
		return 0;
    }
	
	public static void main(String[] args){
		System.out.println(GetUglyNumber_Solution(1));
	}
}
