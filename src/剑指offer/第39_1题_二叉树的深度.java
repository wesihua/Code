package 剑指offer;

public class 第39_1题_二叉树的深度 {
	public int TreeDepth(TreeNode root) {
		//return searchDepth(root, 1);
		return searchDepth(root);
    }
	
	public int searchDepth(TreeNode root,int level){
		if(root==null)
			return level-1;
		
		int leftDepth = searchDepth(root.left, level+1);
		int rightDepth = searchDepth(root.right, level+1);
		
		return Math.max(leftDepth, rightDepth);
	}
	
	public int searchDepth(TreeNode root) {
		if(root==null)
			return 0;
		
		int left = searchDepth(root.left);
		int right = searchDepth(root.right);
		
		return Math.max(left, right)+1;
	}
	
}
