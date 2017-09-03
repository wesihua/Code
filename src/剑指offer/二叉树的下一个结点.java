package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的下一个结点 {
	public static TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode==null)
			return null;
		else if(pNode.right!=null){
			//如果右孩子不为空，那么循环遍历右孩子的左结点到左结点
			pNode = pNode.right;
			while(pNode.left!=null){
				pNode = pNode.left;
			}
			return pNode;
		}
		else if(pNode.next!=null){
			//如果右孩子为空，那么检查父结点时候为空
			//父结点不为空，检查是父结点的左孩子还是右孩子
			//是父结点的左孩子，返回父结点
			if(pNode.next.left == pNode){
				return pNode.next;
			}
			else{
				//是父结点的右孩子，那么检查父结点是否是其父结点的左孩子
				if(pNode.next.next.left == pNode.next)
					return pNode.next.next;
			}
		}
		
		return null;
	}
	
//	public static TreeLinkNode GetNext(TreeLinkNode pNode)
//    {
//        if(pNode==null){
//        	return null;
//        }
//        
//        ArrayList<TreeLinkNode> list = new ArrayList<>();
//        if(pNode.next!=null && pNode.next.next!=null){
//        	//System.out.println(1);
//        	midorderTravel(pNode.next.next, list, pNode);
//        }
//        else if(pNode.next!=null){
//        	System.out.println(2);
//        	midorderTravel(pNode.next, list, pNode);
//        }
//        else{
//        	System.out.println(3);
//        	midorderTravel(pNode, list, pNode);
//        }
//        
//        if(list.size()!=0){
//        	if(list.get(0)==pNode)
//        		return null;
//        	else
//        		return list.get(0);
//        }
//        else
//        	return null;
//    }
//	
//	public static void midorderTravel(TreeLinkNode root,ArrayList<TreeLinkNode> list,TreeLinkNode pNode){
//		if(root==null)
//			return;
//		midorderTravel(root.left,list,pNode);
//		if(list.size()==0 && root==pNode)
//			list.add(root);
//		else if(list.size()!=0 && list.get(0)==pNode){
//			list.set(0, root);
//		}
//		//list.add(root);
//		midorderTravel(root.right,list,pNode);
//	}
	
	public static void main(String args[]){
		TreeLinkNode node_8 = new TreeLinkNode(8);
		TreeLinkNode node_6 = new TreeLinkNode(6);
		TreeLinkNode node_10 = new TreeLinkNode(10);
		TreeLinkNode node_5 = new TreeLinkNode(5);
		TreeLinkNode node_7 = new TreeLinkNode(7);
		TreeLinkNode node_9 = new TreeLinkNode(9);
		TreeLinkNode node_11 = new TreeLinkNode(11);
		
		node_8.left = node_6;
		node_8.right = node_10;
		node_6.next = node_8;
		node_6.left = node_5;
		node_6.right = node_7;
		node_10.next = node_8;
		node_10.left = node_9;
		node_10.right = node_11;
		node_5.next = node_6;
		node_7.next = node_6;
		node_9.next = node_10;
		node_11.next = node_10;
		
		System.out.println(GetNext(node_11).val);
	}
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
