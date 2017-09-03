package leetcode;

import java.util.ArrayList;

public class binary_tree_traversal {
	protected int i = 0;
	
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		preorderTraversalRecur(root,result);
		return result;
	}
	
	public void preorderTraversalRecur(TreeNode root,ArrayList<Integer> result){
		if(root==null)
			return;
		result.add(root.val);
		preorderTraversalRecur(root.left,result);
		preorderTraversalRecur(root.right,result);
	}
	
	
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<>();
		postorderTraversalRecur(root, result);
		return result;
	}
	
	public void postorderTraversalRecur(TreeNode root,ArrayList<Integer> result){
		if(root == null)
			return ;
		else if(root.left==null&&root.right==null){
			result.add(root.val);
			return;
		}
		
		postorderTraversalRecur(root.left,result);
		postorderTraversalRecur(root.right,result);
		result.add(root.val);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		binary_tree_traversal binary_tree_traversal = new binary_tree_traversal();
		ArrayList<Integer> list = binary_tree_traversal.preorderTraversal(root);
		for(Integer val:list){
			System.out.println(val);
		}
	}
}
