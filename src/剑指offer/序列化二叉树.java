package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 序列化二叉树 {
	static String Serialize(TreeNode root) {
		StringBuilder stringBuilder = new StringBuilder();
		preorderTravel(root, stringBuilder);
		
		if(stringBuilder.charAt(stringBuilder.length()-1)==',')
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		
		return stringBuilder.toString();
	}
	
	static void preorderTravel(TreeNode root,StringBuilder stringBuilder){
		if(root==null){
			stringBuilder.append("$,");
			return;
		}
		stringBuilder.append(root.val+",");
		preorderTravel(root.left, stringBuilder);
		preorderTravel(root.right, stringBuilder);
	}
	
	static TreeNode Deserialize(String str) {
		String[] strs = str.split(",");
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<strs.length;i++){
			list.add(strs[i]);
		}
		if(list.size()==0||list.get(0).equals("$"))
			return null;
		TreeNode head = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		
		rebuildTree(head,list);
		
		return head;
	}
	
	static void rebuildTree(TreeNode root,List<String> list){
		if(list.size()==0)
			return;
		if(list.get(0).equals("$")){
			list.remove(0);
		}
		else{
			TreeNode treeNode1 = new TreeNode(Integer.valueOf(list.get(0)));
			list.remove(0);
			root.left = treeNode1;
			rebuildTree(treeNode1, list);
		}
		
		if(list.size()==0)
			return;
		if(list.get(0).equals("$")){
			list.remove(0);
		}
		else{
			TreeNode treeNode2 = new TreeNode(Integer.valueOf(list.get(0)));
			list.remove(0);
			root.right = treeNode2;
			rebuildTree(treeNode2, list);
		}
	}
	
	public static void main(String args[]){
		TreeNode node_8 = new TreeNode(8);
		TreeNode node_6 = new TreeNode(6);
		TreeNode node_10 = new TreeNode(10);
		TreeNode node_5 = new TreeNode(5);
		TreeNode node_7 = new TreeNode(7);
		TreeNode node_9 = new TreeNode(9);
		TreeNode node_11 = new TreeNode(11);
		
		node_8.left = node_6;
		node_8.right = node_10;
		node_6.left = node_5;
		node_6.right = node_7;
		node_10.left = node_9;
		node_10.right = node_11;
		
		System.out.println(Serialize(node_8));
		
		TreeNode head = Deserialize(Serialize(node_8));
		System.out.println(head.val);
		System.out.println(head.left.val);
		System.out.println(head.right.val);
	}
}
