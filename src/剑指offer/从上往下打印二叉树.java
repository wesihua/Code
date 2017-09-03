package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 从上往下打印二叉树 {
	
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
        	return list;
        list.add(root.val);
        linkedList.add(root.left);
        linkedList.add(root.right);
        while(linkedList.size()!=0){
        	TreeNode node = linkedList.poll();
        	if(node!=null){
        		list.add(node.val);
        		linkedList.add(node.left);
        		linkedList.add(node.right);
        	}
        }
        return list;
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);
		System.out.println(PrintFromTopToBottom(root));
		
		
	}
}
