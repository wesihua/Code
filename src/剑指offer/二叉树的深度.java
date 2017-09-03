package 剑指offer;

public class 二叉树的深度 {
	public int TreeDepth(TreeNode root) {
		return searchDepth(root, 1);
    }
	
	public int searchDepth(TreeNode root,int level){
		if(root==null)
			return level-1;
		
		int leftDepth = searchDepth(root.left, level+1);
		int rightDepth = searchDepth(root.right, level+1);
		
		return Math.max(leftDepth, rightDepth);
	}
	
}
