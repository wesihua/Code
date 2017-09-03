package 剑指offer;

public class 二叉树搜索树的后序遍历序列 {
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length==0)
			return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
	
	public static boolean VerifySquenceOfBST(int[] sequence,int start,int end,Integer upperBound,Integer lowerBound){
		int root = sequence[end];
		if(start==end){
			//System.out.println("root:"+root+"  upperBound:"+upperBound+"  lowerBound:"+lowerBound);
			if(root<=upperBound&&root>lowerBound)
				return true;
			else
				return false;
		}
		
		int index = -1;
		for(int i=end;i>=start;i--){
			if(sequence[i]<root){
				index = i;
				break;
			}
		}
		
		//System.out.println(start+" "+index+" "+end);
		boolean left = true;
		boolean right = true;
		if(index!=-1){
			left = VerifySquenceOfBST(sequence, start, index, root-1, lowerBound);
			if(index+1<=end-1)
				right = VerifySquenceOfBST(sequence, index+1, end-1, upperBound, root);
		}
		else
			right = VerifySquenceOfBST(sequence, start, end-1, upperBound, root);
		
		
		if(left&&right){
			//System.out.println("root:"+root+"  upperBound:"+upperBound+"  lowerBound:"+lowerBound);
			if(root<=upperBound&&root>lowerBound)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public static void main(String[] args){
		//int[] sequence = {7,6,5,9,8,11,14,16,15,13,10};
		//int[] sequence = {5,4,3,2,1};
		int[] sequence = {4,8,7,5};
		System.out.println(VerifySquenceOfBST(sequence));
	}
}
