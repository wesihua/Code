package data_structure.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeTraversal {
	
	//先序遍历递归版本
	public static void preorder(BinaryTree root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	//中序遍历递归版本
	public static void inorder(BinaryTree root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	//后序遍历递归版本
	public static void postorder(BinaryTree root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	//先序遍历非递归版本
	public static void preorderTaversal(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<>();
		while(root!=null || !stack.empty()) {
			while(root!=null) {
				System.out.print(root.data+" ");
				stack.push(root);
				root = root.left;
			}
			if(!stack.empty()) {
				root = stack.pop();
				root = root.right;
			}
		}
	}
	
	//中序遍历非递归版本
	public static void inorderTraversal(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<>();
		while(root!=null || !stack.empty()) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			if(!stack.empty()) {
				root = stack.pop();
				System.out.print(root.data+" ");
				root = root.right;
			}
		}
	}
	
	//后序遍历非递归版本
	public static void postorderTraversal(BinaryTree root) {
		Stack<BinaryTree> stack = new Stack<>();
		Set<BinaryTree> set = new HashSet<>();
		while(root!=null || !stack.empty()) {
			while(root!=null) {
				stack.push(root);
				root = root.left;
			}
			if(!stack.empty()) {
				root = stack.pop();
				if(!set.contains(root)) {
					stack.push(root);
					set.add(root);
					root = root.right;
				}
				else {
					System.out.print(root.data+" ");
					root = null;
				}
			}
		}
	}
	
	public static void preorderTraveralNew(BinaryTree root) {
		
	}
	
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(0);
		
		root.left = new BinaryTree(1);
		root.left.left = new BinaryTree(2);
		root.left.left.left = new BinaryTree(3);
		root.left.right = new BinaryTree(4);
		root.left.right.left = new BinaryTree(5);
		
		root.right = new BinaryTree(6);
		root.right.left = new BinaryTree(7);
		root.right.right = new BinaryTree(8);
		root.right.right.left = new BinaryTree(9);
		root.right.right.right = new BinaryTree(10);
		
		System.out.println("先序遍历：");
		preorder(root);
		System.out.println();
		preorderTaversal(root);
		System.out.println();
		
		System.out.println("中序遍历");
		inorder(root);
		System.out.println();
		inorderTraversal(root);
		System.out.println();
		
		System.out.println("后序遍历");
		postorder(root);
		System.out.println();
		postorderTraversal(root);
		System.out.println();
	}
	
}

class BinaryTree{
	BinaryTree left;
	BinaryTree right;
	int data;
	
	public BinaryTree(int data) {
		this.data = data;
	}
}
