package 剑指offer;

import java.util.ArrayList;

import data_structure.tree.Tree;

public class 第27题_二叉搜索树与双向链表 {
//	/**
//	 * 非递归版本，将中序遍历的结果保存到一个list中去，再按照中序遍历的结果修改相应的指针
//	 * 时间复杂度O(n)，空间复杂度O(n)
//	 * @param pRootOfTree
//	 * @return
//	 */
//	public static TreeNode Convert(TreeNode pRootOfTree) {
//		if(pRootOfTree==null||(pRootOfTree.left==null&&pRootOfTree.right==null))
//			return pRootOfTree;
//		ArrayList<TreeNode> list = new ArrayList<>();
//		Convert(pRootOfTree, list);
//		
//		int length = list.size();
//		for(int i=0;i<=length-1;i++){
//			if(i==0){
//				list.get(i).left = null;
//				list.get(i).right = list.get(i+1);
//			}
//			else if(i==length-1){
//				list.get(i).left = list.get(i-1);
//				list.get(i).right = null;
//			}
//			else{
//				list.get(i).left = list.get(i-1);
//				list.get(i).right = list.get(i+1);
//			}
//				
//		}
//		
//		return list.get(0);
//    }
//	
//	public static void Convert(TreeNode pRootOfTree,ArrayList<TreeNode> list){
//		if(pRootOfTree==null)
//			return;
//		Convert(pRootOfTree.left,list);
//		list.add(pRootOfTree);
//		Convert(pRootOfTree.right,list);
//	}
	
	//双向链表的左边头结点和右边头节点
    TreeNode leftHead = null;
    TreeNode rightHead = null;
	
    /**
     * 递归版本
     * 
     * @param pRootOfTree
     * @return
     */
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null)
			return null;
		
		Convert(pRootOfTree.left);
		
		//递归遍历完左子树返回后，更新rightHead和leftHead
		//rightHead是遍历完左子树后调整得到的双向链表的表尾节点
		if(rightHead==null) {
			leftHead = rightHead = pRootOfTree;
		}
		else {
			pRootOfTree.left = rightHead;
			rightHead.right = pRootOfTree;
			rightHead = pRootOfTree;
		}
		
		Convert(pRootOfTree.right);
		return leftHead;
	}
	
	
	
	public static void main(String[] args){
		ArrayList<TreeNode> list = new ArrayList<>();
		TreeNode head = new TreeNode(1);
//		head.left = new TreeNode(8);
//		head.left.left = new TreeNode(5);
//		//head.left.left.left = new TreeNode(3);
//		head.left.left.right = new TreeNode(6);
//		head.left.right = new TreeNode(9);
//		head.right = new TreeNode(13);
//		head.right.left = new TreeNode(11);
//		head.right.right = new TreeNode(15);
//		head.right.right.left = new TreeNode(14);
//		head.right.right.right = new TreeNode(16);
		
		第27题_二叉搜索树与双向链表 class_ = new 第27题_二叉搜索树与双向链表();
		
		TreeNode treeNode = class_.Convert(head);
		
		while(treeNode.right!=null){
			System.out.print(treeNode.val+" ");
			treeNode = treeNode.right;
		}
		System.out.println(treeNode.val);
		
		if(treeNode.left==null){
			System.out.println("!!!");
		}
		
		while(treeNode.left!=null){
			System.out.print(treeNode.val+" ");
			treeNode = treeNode.left;
		}
		
	}
}
