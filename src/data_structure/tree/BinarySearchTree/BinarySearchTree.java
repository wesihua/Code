package data_structure.tree.BinarySearchTree;

import data_structure.tree.Tree;
import data_structure.tree.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private BinaryNode<T> root;
	public int size;
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if(size==0)
			return true;
		
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String levelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T data) {
		if (data==null)
            throw new RuntimeException("data can\'Comparable be null !");
		
		root = insert(root, data);
		size++;
	}
	
	private BinaryNode<T> insert(BinaryNode<T> root,T data) {
		if(root==null)
			return new BinaryNode<T>(data);
		
		if(root.data.compareTo(data)>0)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		
		return root;
	}

	@Override
	public void remove(T data) {
		if (data==null)
            throw new RuntimeException("data can\'Comparable be null !");
		
		root = remove(root, data);
		size--;
	}
	
	private BinaryNode<T> remove(BinaryNode<T> root,T data){
		if(root==null)
			return root;
		
		int compareResult = root.data.compareTo(data);
		
		if(compareResult>0) //从左子树删除节点
			root.left = remove(root.left, data);
		else if(compareResult<0) //从右子树删除节点
			root.right = remove(root.right, data);
		else if(root.right!=null&&root.right.data.compareTo(data)==0) {
			//处理一下有元素相等的情况(元素相等的话都是插到右子树)
			root.right = remove(root.right, data);
		}
		else if(root.left!=null&&root.right!=null) {
			//找到要删除的节点，如果其左右子树都不为空，则找出右子树中最小的节点与该节点进行值的交换，然后删除右子树中最小的节点
			root.data = findMin(root.right).data;
			root.right = remove(root.right, root.data);
		}
		else//左右子树有一个为空或者都为空，则只需要将左子树或者右子树提升
			root = root.left!=null?root.left:root.right;
		
		return root;
	}

	@Override
	public T findMin() {
		if(isEmpty())
			throw new RuntimeException("BinarySearchTree is empty!");
		
		return findMin(root).data;
	}

	private BinaryNode<T> findMin(BinaryNode<T> root) {
		if(root==null)
			return null;
		else if(root.left==null)
			return root;
		else
			return findMin(root.left);
	}
	
	@Override
	public T findMax() {
		if(isEmpty())
			throw new RuntimeException("BinarySearchTree is empty!");
		
		return findMax(root).data;
	}
	
	private BinaryNode<T> findMax(BinaryNode<T> root){
		if(root==null)
			return null;
		else if(root.right==null)
			return root;
		else
			return findMax(root);
	}

	@Override
	public TreeNode findNode(T data) {
		if (data==null)
            throw new RuntimeException("data can\'Comparable be null !");
		
		BinaryNode<T> tempRoot = root;
		
		while(tempRoot!=null) {
			int compareResult = tempRoot.data.compareTo(data);
			if(compareResult==0)
				return tempRoot;
			else if(compareResult>0)
				tempRoot = tempRoot.left;
			else
				tempRoot = tempRoot.right;
		}
		
		return null;
	}

	@Override
	public boolean contains(T data) throws Exception {
		if(findNode(data)==null)
			return false;
		else
			return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
