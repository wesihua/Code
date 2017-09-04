package 剑指offer;

import java.util.HashMap;

public class 第26题_复杂链表的复制 {
	
	//首先顺着next指针对链表复制，在复制的过程中，用map来记录原本与副本的映射关系
	//然后再从头遍历原来的链表，利用map为刚刚复制的链表设置random指针
	//时间复杂度O(n)，空间复杂度O(n)
	public static RandomListNode Clone(RandomListNode pHead)
    {
		if(pHead==null)
			return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode tempHead = pHead;
		RandomListNode cloneHead = new RandomListNode(pHead.label);
		map.put(pHead, cloneHead);
		RandomListNode tempCloneHead = cloneHead;
		tempHead = tempHead.next;
		while(tempHead!=null){
			tempCloneHead.next = new RandomListNode(tempHead.label);
			map.put(tempCloneHead.next, tempHead);
			tempCloneHead = tempCloneHead.next;
			tempHead = tempHead.next;
		}
		
		tempHead = pHead;
		tempCloneHead = cloneHead;
		while(tempHead!=null){
			if(tempHead.random!=null){
				if(map.containsKey(tempHead.random))
					tempCloneHead.random = map.get(tempHead.random);
				else
					tempCloneHead.random = new RandomListNode(tempHead.random.label);
			}
			
			tempCloneHead = tempCloneHead.next;
			tempHead = tempHead.next;
		}
		
		return cloneHead;
		
    }
	
	/**
	 * 	1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
        2、遍历链表，A1->random = A->random->next;
        3、将链表拆分成原链表和复制后的链表
	 *  时间复杂度O(n)，空间复杂度O(1)
	 *  
	 * @param pHead
	 * @return
	 */
	public static RandomListNode Clone2(RandomListNode pHead)
    {
		if(pHead==null)
			return null;
		
		//复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
		RandomListNode tempHead = pHead;
		while(tempHead!=null) {
			RandomListNode node = new RandomListNode(tempHead.label);
			node.next = tempHead.next;
			tempHead.next = node;
			tempHead = node.next;
		}
		
		//复制random
		tempHead = pHead;
		while(tempHead!=null) {
			if(tempHead.random!=null) {
				tempHead.next.random = tempHead.random.next;
			}
			tempHead = tempHead.next.next;
		}
		
		//拆分链表
		RandomListNode cloneHead = pHead.next;
		RandomListNode tempCloneHead = cloneHead;
		tempHead = pHead;
		while(tempHead!=null) {
			tempHead.next = tempCloneHead.next;
			if(tempHead.next!=null)
				tempCloneHead.next = tempHead.next.next;
			tempHead = tempHead.next;
			tempCloneHead = tempCloneHead.next;
		}
		
		return cloneHead;
    }
	
	public static void main(String[] args){
		RandomListNode head = new RandomListNode(0);
		head.next = new RandomListNode(1);
		head.next.next = new RandomListNode(2);
		head.random = new RandomListNode(3);
		head.random.next = new RandomListNode(4);
		
		RandomListNode cloneHead = Clone(head);
		
		System.out.println(cloneHead==head);
		System.out.println(cloneHead.next.next.label);
		System.out.println(cloneHead.random.next.label);
		
	}
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
