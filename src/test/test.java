package test;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class test {
	
	public ListNode merge(ListNode l1,ListNode l2){
		ListNode head = new ListNode(0);
		ListNode tempHead = head;
		
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				tempHead.next = l1;
				l1 = l1.next;
			}
			else{
				tempHead.next = l2;
				l2 = l2.next;
			}
			
			tempHead = tempHead.next;
		}
		
		if(l1!=null){
			tempHead.next = l1;
		}
		
		if(l2!=null){
			tempHead.next = l2;
		}
		
		return head.next;
	}
}

class ListNode{
	
	ListNode next = null;
	int val;
	
	public ListNode(int val) {
		this.val = val;
	}
}
