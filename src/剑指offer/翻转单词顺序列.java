package 剑指offer;

import java.util.Arrays;

public class 翻转单词顺序列 {
	public static String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder(str);
        reverse(sb, 0, sb.length()-1);
        int start = 0;
        int end = 0;
        //System.out.println(sb.toString());
        while(end<=sb.length()-1){
            if(sb.charAt(end)==' '){
                if(start!=end){
                	//System.out.println("start:"+start+" end:"+end);
                    reverse(sb,start,end-1);
                    start = end;
                }
                start++;
                end++;
            }
            else if(sb.charAt(end)!=' '){
                end++;
            }
        }
        
        if(start!=end){
            reverse(sb,start,end-1);
        }
        
        return sb.toString();
    }
    
    public static void reverse(StringBuilder sb,int start,int end){
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
        //System.out.println(sb.toString());
    }
    
    public static void main(String[] args){
    	System.out.println(ReverseSentence("I have a dream!"));
    	System.out.println(String.format("%08x", 11));
    }
}
