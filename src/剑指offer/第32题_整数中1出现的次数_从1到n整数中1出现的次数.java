package 剑指offer;

public class 第32题_整数中1出现的次数_从1到n整数中1出现的次数 {
//	public static int NumberOf1Between1AndN_Solution(int n) {
//		int sum = 0;
//		String nStr = String.valueOf(n);
//		if(nStr.length()==1){
//			if(n>=1)
//				return 1;
//			else
//				return 0;
//		}
//		for(int i=nStr.length()-1;i>=0;i--){
//			int num = nStr.charAt(i)-48;
//			if(i==nStr.length()-1){
//				if(num>=1)
//					sum += Integer.valueOf(nStr.substring(0, i))+1;
//				else
//					sum += Integer.valueOf(nStr.substring(0, i));
//			}
//			else if(i==0){
//				if(num==1)
//					sum += Integer.valueOf(nStr.substring(1, nStr.length()))+1;
//				else
//					sum += (num-1)*Math.pow(10, nStr.length()-1);
//			}
//			else{
//				int high = Integer.valueOf(nStr.substring(0,i));
//				int low = Integer.valueOf(nStr.substring(i+1,nStr.length()));
//				int grade = (int) Math.pow(10, nStr.length()-1-i);
//				if(num==0)
//					sum += high*grade;
//				else if(num==1)
//					sum += high*grade + low + 1;
//				else
//					sum += (high+1)*grade;
//			}
//		}
//		
//		return sum;
//    }
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf1Between1AndN_Solution(int n){
		int sum = 0;
		int factor = 1;
		int highNum = 0;
		int lowNum = 0;
		int curNum = 0;
		
		while(n/factor>0){
			curNum = (n%(factor*10))/factor;
			lowNum = n%(factor*10)-curNum*factor;
			highNum = n/(factor*10);
			
			if(curNum==0){
				sum += highNum*factor;
			}
			else if(curNum==1){
				sum += highNum*factor+lowNum+1;
			}
			else{
				sum += (highNum+1)*factor;
			}
			
			factor *= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		System.out.println(NumberOf1Between1AndN_Solution(14));
	}
}
