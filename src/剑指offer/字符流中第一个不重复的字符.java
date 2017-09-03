package 剑指offer;

public class 字符流中第一个不重复的字符 {
	int[] flag = new int[256];
	int count = 0;
    
    {
        for(int i=0;i<flag.length;i++){
            flag[i] = -1;
        }
    }
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(flag[ch]==-1)
        	flag[ch] = count;
        else if(flag[ch]>=0)
        	flag[ch] = -2;
        count++;
        	
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	int min = Integer.MAX_VALUE;
    	char ch = '#';
    	for(int i=0;i<flag.length;i++){
    		if(flag[i]>=0&&flag[i]<min){
    			min = flag[i];
    			ch = (char)i;
    		}
    	}
    	
    	return ch;
    }
    
    public static void main(String args[]){
    	字符流中第一个不重复的字符 test = new 字符流中第一个不重复的字符();
    	test.Insert('g');
    	System.out.println(test.FirstAppearingOnce());
    	test.Insert('o');
    	System.out.println(test.FirstAppearingOnce());
    	test.Insert('o');
    	System.out.println(test.FirstAppearingOnce());
    	test.Insert('g');
    	System.out.println(test.FirstAppearingOnce());
    	test.Insert('l');
    	System.out.println(test.FirstAppearingOnce());
    	test.Insert('e');
    	System.out.println(test.FirstAppearingOnce());
    }
}
