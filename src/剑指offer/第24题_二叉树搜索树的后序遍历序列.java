package 剑指offer;

public class 第24题_二叉树搜索树的后序遍历序列 {
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length==0)
			return false;
        //return VerifySquenceOfBST(sequence, 0, sequence.length-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
		return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }
	
	//BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
	//那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 。
	public static boolean VerifySquenceOfBST(int[] sequence,int start,int end) {
		if(start>=end) return true;
		
		//bound记录第一个大于等于sequence[end]的数的前一个位置
		int bound = start;
		for(int i=start;i<end;i++) {
			if(sequence[i]>=sequence[end]) {
				break;
			}
			bound = i;
		}
		
		for(int i=bound+1;i<end;i++) {
			if(sequence[i]<sequence[end]) {
				return false;
			}
		}
		
		return VerifySquenceOfBST(sequence,start,bound) && VerifySquenceOfBST(sequence, bound+1, end-1);
	}
	
//	public static boolean VerifySquenceOfBST(int[] sequence,int start,int end,Integer upperBound,Integer lowerBound){
//		int root = sequence[end];
//		if(start==end){
//			//System.out.println("root:"+root+"  upperBound:"+upperBound+"  lowerBound:"+lowerBound);
//			if(root<=upperBound&&root>lowerBound)
//				return true;
//			else
//				return false;
//		}
//		
//		int index = -1;
//		for(int i=end;i>=start;i--){
//			if(sequence[i]<root){
//				index = i;
//				break;
//			}
//		}
//		
//		//System.out.println(start+" "+index+" "+end);
//		boolean left = true;
//		boolean right = true;
//		if(index!=-1){
//			left = VerifySquenceOfBST(sequence, start, index, root-1, lowerBound);
//			if(index+1<=end-1)
//				right = VerifySquenceOfBST(sequence, index+1, end-1, upperBound, root);
//		}
//		else
//			right = VerifySquenceOfBST(sequence, start, end-1, upperBound, root);
//		
//		
//		if(left&&right){
//			//System.out.println("root:"+root+"  upperBound:"+upperBound+"  lowerBound:"+lowerBound);
//			if(root<=upperBound&&root>lowerBound)
//				return true;
//			else
//				return false;
//		}
//		else
//			return false;
//	}
	
	public static void main(String[] args){
		//int[] sequence = {7,6,5,9,8,11,14,16,15,13,10};
		//int[] sequence = {5,4,3,2,1};
		int[] sequence = {4,6,7,5};
		System.out.println(VerifySquenceOfBST(sequence));
	}
}
