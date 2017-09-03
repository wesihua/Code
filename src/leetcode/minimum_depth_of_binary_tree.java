package leetcode;

/**
 *  题目描述：
	Given a binary tree, find its minimum depth.The minimum depth is the
	number of nodes along the shortest path from the root node down to the
	nearest leaf node.
 * @author zhenlanghuo
 *
 */
public class minimum_depth_of_binary_tree {
	public int run(TreeNode root){
		if(root == null)
			return 0;
		else if(root.left == null && root.right == null)
			return 1;
		else{
			int min_left = run(root.left);
			int min_right = run(root.right);
			if(min_left == 0 || min_right == 0)
				return min_left+min_right+1;
			
			if(min_left<min_right)
				return min_left+1;
			else
				return min_right+1;
		}
	}
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
