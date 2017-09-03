package 剑指offer;

public class 表示数值的字符串 {
	public static boolean isNumeric(char[] str) {
		int firstE_index = -1;
        for(int i=0;i<str.length;i++){
        	if(str[i]=='e'||str[i]=='E'){
        		firstE_index = i;
        		break;
        	}
        }
        
        if(firstE_index!=-1){
        	return isNumericWithoutE(str, 0, firstE_index-1,false)
        			&& isNumericWithoutE(str, firstE_index+1, str.length-1,true);
        }
        else{
        	System.out.println("!!!");
        	return isNumericWithoutE(str, 0, str.length-1,false);
        }
        
    }
	
	public static boolean isNumericWithoutE(char[] str,int start,int end,boolean isInteger){
		if(start>end)
			return false;
		if(start==end && (str[start]=='+'||str[start]=='-')){
			return false;
		}
		if(!((str[start]-'0'>=0&&str[start]-'0'<=9)||str[start]=='+'||str[start]=='-'))
            return false;
		
        int radix_point_index = -1;
    	for(int i=start+1;i<=end;i++){
        	if(str[i]-'0'>=0&&str[i]-'0'<=9)
                continue;
            else if(!isInteger&&str[i]=='.'){
            	if(i==start)
                    return false;
                if(radix_point_index!=-1)
                    return false;
                if(i==end)
                	return false;
                radix_point_index = i;
            }
            else
                return false;
        }
    	
    	return true;
	}

	public static void main(String[] args){
		char[] str = {'1','2','3','.','4','5','e','1'};
		System.out.println(isNumeric(str));
	}
}
