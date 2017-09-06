package data_structure.tree.BinarySearchTree;

import data_structure.tree.TreeNode;

public class BinaryNode<T extends Comparable<T>> extends TreeNode<T> {
	
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	public T data;
	
	public BinaryNode(T data) {
		this.data = data;
	}
	
}
