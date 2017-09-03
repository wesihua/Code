package data_structure.tree.AVLTree;

import data_structure.tree.TreeNode;

public class AVLNode<T extends Comparable<T>> extends TreeNode<T> {
	
	public AVLNode<T> left;
	
	public AVLNode<T> right;
	
	public T data;
	
	//当前结点的高度
	public int height;
	
	public AVLNode(T data) {
		this.data = data;
	}
	
}
