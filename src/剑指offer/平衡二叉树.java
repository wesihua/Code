package 剑指offer;

public class 平衡二叉树 {
	public boolean IsBalanced_Solution(TreeNode root) {
        return IsBalanced(root, 1).flag;
    }
	
	class LevelAndFlag{
		boolean flag = true;
		int level = 0;
		
		public LevelAndFlag(int level,boolean flag) {
			this.level = level;
			this.flag = flag;
		}
	}
	
	public LevelAndFlag IsBalanced(TreeNode root,int level){
		if(root==null)
			return new LevelAndFlag(level-1,true);
		
		LevelAndFlag left = IsBalanced(root.left, level+1);
		LevelAndFlag right = null;
		if(!left.flag)
			return new LevelAndFlag(level, false);
		else{
			right = IsBalanced(root.right, level+1);
			if(right.flag){
				if(Math.abs(left.level-right.level)<=1)
					return new LevelAndFlag(Math.max(left.level, right.level), true);
				else
					return new LevelAndFlag(level, false);
			}
			else
				return new LevelAndFlag(level, false);
		}
		
	}
	
	
}
