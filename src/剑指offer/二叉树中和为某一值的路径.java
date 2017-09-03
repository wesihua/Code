package 剑指offer;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(root==null)
        	return list;
        
        FindPath(root, target, temp, list);        
        return list;
    }
	
	public static void FindPath(TreeNode root,int target,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> list){
		if(root == null)
			return;
		temp.add(root.val);
		target = target - root.val;
		if(target<0)
			return;
		if(target==0&&root.left==null&&root.right==null){
			ArrayList<Integer> result = new ArrayList<>(temp);
			list.add(result);
		}
		
		FindPath(root.left, target, temp, list);
		FindPath(root.right, target, temp, list);
		temp.remove(temp.size()-1);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		
		ArrayList<ArrayList<Integer>> list = FindPath(root, 22);
		
		for(ArrayList<Integer> list_:list){
			System.out.println(list_);
		}
	}
	
	
}
