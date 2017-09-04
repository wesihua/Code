package 剑指offer;

import java.util.ArrayList;

public class 第25题_二叉树中和为某一值的路径 {
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(root==null)
        	return list;
        
        FindPath(root, target, temp, list);        
        return list;
    }
	
	/**
	 * 问题：根节点为root，找出从root出发的路径和为target的路径
	 * 这个问题可以分解为求以root.left为根节点，找出从root.left出发的路径和为target-root.left.val的路径
	 * 和以root.right为根节点，找出从root.right出发的路径和为target-root.right.val的路径
	 * 所以可以利用递归对子问题进行处理
	 * @param root		根节点
	 * @param target	target是目标值
	 * @param temp		用来保存目前遍历路径上的节点
	 * @param list		用来保存符合要求的路径
	 */
	public static void FindPath(TreeNode root,int target,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> list){
		if(root == null)
			return;
		temp.add(root.val);
		//target表示遍历到该节点时，距离目标的路径和还有多少差距
		target = target - root.val;
		//如果target小于0，表明正在遍历的路径不可能符合要求了，返回
		if(target<0)
			return;
		//如果target==0，同时还要检查root是否叶子节点，如果是叶子节点，则表明已经找到符合要求的路径了，将temp中保存的路径添加到list中去
		if(target==0&&root.left==null&&root.right==null){
			ArrayList<Integer> result = new ArrayList<>(temp);
			list.add(result);
		}
		
		FindPath(root.left, target, temp, list);
		FindPath(root.right, target, temp, list);
		//经过root节点的路径已经全部遍历完了，递归返回的时候需要将该节点从temp中删除
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
