package 剑指offer;

import java.util.HashMap;

public class 复杂链表的复制 {
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
