package 剑指offer;

public class 第39_2题_平衡二叉树 {
	public boolean IsBalanced_Solution(TreeNode root) {
        if(IsBalanced(root)==-1)
        	return false;
        else
        	return true;
    }
	
	class LevelAndFlag{
		boolean flag = true;
		int level = 0;
		
		public LevelAndFlag(int level,boolean flag) {
			this.level = level;
			this.flag = flag;
		}
	}
	
//	public LevelAndFlag IsBalanced(TreeNode root,int level){
//		if(root==null)
//			return new LevelAndFlag(level-1,true);
//		
//		LevelAndFlag left = IsBalanced(root.left, level+1);
//		LevelAndFlag right = null;
//		if(!left.flag)
//			return new LevelAndFlag(level, false);
//		else{
//			right = IsBalanced(root.right, level+1);
//			if(right.flag){
//				if(Math.abs(left.level-right.level)<=1)
//					return new LevelAndFlag(Math.max(left.level, right.level), true);
//				else
//					return new LevelAndFlag(level, false);
//			}
//			else
//				return new LevelAndFlag(level, false);
//		}
//		
//	}
	
	public int IsBalanced(TreeNode root,int level) {
		if(root==null)
			return level-1;
		
		int left = IsBalanced(root.left, level+1);
		int right = IsBalanced(root.right, level+1);
		
		if(left==-1||right==-1)
			return -1;
		else if(Math.abs(left-right)<=1)
			return Math.max(left, right);
		else
			return -1;
	}
	
	public int IsBalanced(TreeNode root) {
		if(root==null)
			return 0;
		
		int left = IsBalanced(root.left);
		int right = IsBalanced(root.right);
		
		if(left==-1||right==-1)
			return -1;
		else if(Math.abs(left-right)<=1)
			return Math.max(left, right)+1;
		else
			return -1;
	}
	
}
