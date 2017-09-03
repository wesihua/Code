package 剑指offer;

public class 正则表达式匹配 {
	public static boolean match(char[] str, char[] pattern)
    {
        return match(str, 0, pattern, 0);
    }
	
//	public static boolean match(char[] str,int str_start,char[] pattern,int pattern_start){
//		
//		//pattern到尾，str到尾，匹配成功
//		if(pattern_start==pattern.length && str_start==str.length){
//			return true;
//		}
//		//pattern先到尾，匹配失败
//		if(pattern_start==pattern.length && str_start!=str.length){
//			return false;
//		}
//		
//		if(pattern_start<pattern.length-1 && pattern[pattern_start+1]=='*'){
//			if(str_start<str.length && (pattern[pattern_start]=='.' || pattern[pattern_start]==str[str_start])){
//				if(pattern_start+1==pattern.length-1&&str_start==str.length-1)
//					return true;
//				return match(str, str_start+1, pattern, pattern_start)
//					|| match(str, str_start, pattern, pattern_start+2);
//			}
//			else{
//				return match(str, str_start, pattern, pattern_start+2);
//			}
//		}
//		else{
//			if(str_start<str.length && pattern[pattern_start]=='.')
//				return match(str, str_start+1, pattern, pattern_start+1);
//			else if(str_start<str.length && pattern[pattern_start]==str[str_start]){
//				return match(str, str_start+1, pattern, pattern_start+1);
//			}
//			else if(str_start<str.length && pattern[pattern_start]!=str[str_start]){
//				return false;
//			}
//		}
//		
//		
//		return false;
//	}
	
	public static boolean match(char[] str,int strIndex,char[] pattern,int patternIndex){
		//str到尾，pattern到尾，匹配成功
		if(strIndex==str.length && patternIndex == pattern.length){
			return true;
		}
		//pattern先到尾，匹配失败
		if(strIndex!=str.length && patternIndex == pattern.length){
			return false;
		}
		
		if(patternIndex+1<pattern.length && pattern[patternIndex+1]=='*'){
			if((strIndex!=str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex!=str.length)){
				return match(str, strIndex, pattern, patternIndex+2)
						|| match(str, strIndex+1, pattern, patternIndex);
			}
			else{
				return match(str, strIndex, pattern, patternIndex+2);
			}
		}
		
		//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if((strIndex!=str.length&&pattern[patternIndex]==str[strIndex])||(strIndex!=str.length&&pattern[patternIndex]=='.')){
			return match(str, strIndex+1, pattern, patternIndex+1);
		}
		
		return false;
	}
	
	public static void main(String[] args){
		char[] str = {'a'};
		char[] pattern = {'a','b','*'};
		System.out.println(match(str, pattern));
		
	}
}
