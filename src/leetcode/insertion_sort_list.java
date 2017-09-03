package leetcode;

import java.util.List;

public class insertion_sort_list {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode temp = head;
		temp.next = new ListNode(1);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(6);
		temp = temp.next;
		temp.next = new ListNode(4);
		
		
//		while(head!=null){
//			System.out.println(head.val);
//			head = head.next;
//		}
		
		ListNode sortListNode = insertionSortList(head);
		
		while(sortListNode!=null){
			System.out.println(sortListNode.val);
			sortListNode = sortListNode.next;
		}
	}
	
	public static ListNode insertionSortList(ListNode head){
		if(head==null || head.next == null)
            return head;
		
		ListNode new_head = head;
		head = head.next;
		new_head.next = null;
		
		while(head!=null){
//			System.out.println(head.val);
			ListNode preNode = null;
			ListNode curNode = new_head;
			while(curNode!=null){
//				System.out.println(curNode.val);
				if(preNode==null){
					//比头要小
					if(head.val<curNode.val){
						ListNode temp = head;
						head = head.next;
						temp.next = curNode;
						new_head = temp;
						break;
					}
				}
				else{
					if(head.val<curNode.val&&preNode.val<=head.val){
						ListNode temp = head;
						head = head.next;
						temp.next = curNode;
						preNode.next = temp;
						break;
					}
				}
				
				preNode = curNode;
				curNode = curNode.next;
			}
			
			//比所有排好序的都要大
			if(curNode==null){
				ListNode temp = head;
				head = head.next;
				temp.next = null;
				preNode.next = temp;
			}
		}
		
		return new_head;
	}
}

