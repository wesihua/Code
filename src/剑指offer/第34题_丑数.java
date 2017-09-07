package 剑指offer;

import java.util.ArrayList;
import java.util.*;

public class 第34题_丑数 {
	/**
	 * 对于每一个丑数，肯定是前面的一个丑数乘以2或3或5得来的
	 * 那么我们可以从前面已经生成的丑数乘以2或3或5来生成接下来的丑数
	 * 
	 * @param index
	 * @return
	 */
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
        
        //array数组按顺序保存丑数
        //t数组保存的是2、3、5上一次已经相乘的丑数在array数组的位置
        //每一次在辅助t数组的帮助下，找到2、3、5各自乘以array中某个丑数后第一个大于array数组中最后一个丑数的丑数，记录字啊temp数组中
        //每次取temp数组中的最小值来增加到array数组中
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
