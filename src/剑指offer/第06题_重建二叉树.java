package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author zhenlanghuo
 *
 */
public class 第06题_重建二叉树 {
	
	//递归方法
	public TreeNode reConstructBinaryTree_(int [] pre,int [] in){
		//保存每个数字在中序遍历中的位置
		Map<Integer, Integer> numIndexInInMap = new HashMap<>();
		for(int i=0;i<in.length;i++)
			numIndexInInMap.put(in[i], i);
		
		return reConstructBinaryTree_(pre, 0, pre.length-1, in, 0, in.length-1, numIndexInInMap);
	}
	
	private TreeNode reConstructBinaryTree_(int[] pre,int pre_start,int pre_end,int[] in,int in_start,int in_end,Map<Integer, Integer> numIndexInInMap){
		if(pre_start>pre_end)
			return null;
		TreeNode root = new TreeNode(pre[pre_start]);
		
		//root结点代表的数字在中序遍历中的位置
		int rootNumIndexInIn = numIndexInInMap.get(pre[pre_start]);
		
		//root结点的左子树有多少结点
		int numsInleft = rootNumIndexInIn - in_start;
		
		root.left = reConstructBinaryTree_(pre, pre_start+1, pre_start+numsInleft, in, in_start, rootNumIndexInIn-1, numIndexInInMap);
		root.right = reConstructBinaryTree_(pre, pre_start+numsInleft+1, pre_end, in, rootNumIndexInIn+1, in_end, numIndexInInMap);
		
		return root;
		
		
	}
	
//	 //循环方法
//	 public TreeNode reConstructBinaryTree_(int [] pre,int [] in) {
//		 Map<Integer, Integer> numIndexInInMap = new HashMap<>();
//		 for(int i=0;i<in.length;i++)
//			 numIndexInInMap.put(in[i], i);
//		 
//		 TreeNode head = new TreeNode(pre[0]);
//		 for(int i=1;i<pre.length;i++){
//			 TreeNode curNode = head;
//			 //准备插入的数字在中序遍历中的位置
//			 int insertNumIndexInIn = numIndexInInMap.get(pre[i]);
//			 while(true){
//				 int curNodeIndexInIn = numIndexInInMap.get(curNode.val);
//				 if(insertNumIndexInIn < curNodeIndexInIn){
//					 //准备插入的数字在curNode的左子树
//					 if(curNode.left == null){
//						 curNode.left = new TreeNode(pre[i]);
//						 break;
//					 }
//					 else
//						 curNode = curNode.left;
//				 }
//				 else if(insertNumIndexInIn > curNodeIndexInIn){
//					//准备插入的数字在curNode的右子树
//					 if(curNode.right == null){
//						 curNode.right = new TreeNode(pre[i]);
//						 break;
//					 }
//					 else
//						 curNode = curNode.right;
//				 }
//			 }
//		 }
//		 
//		 return head;
//	 }
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
