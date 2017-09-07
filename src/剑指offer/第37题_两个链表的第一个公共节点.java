package 剑指offer;

import java.util.ArrayDeque;

public class 第37题_两个链表的第一个公共节点 {
	//对两个链表进行遍历，将节点分别保存到两个栈中，再对两个栈同时进行遍历，最后一个相同的节点就是两个链表的公共节点
	//还有一种更简单的做法是，先两个链表进行遍历统计出各自的长度l1、l2，然后较长的链表先走|l1-l2|，然后两个链表同时遍历，第一个相同的节点就是两个链表的公共节点
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if(pHead1==null||pHead2==null)
 			return null;
 		if(pHead1==pHead2)
 			return pHead1;
		
		ArrayDeque<ListNode> pHead1_list = new ArrayDeque<>();
 		ArrayDeque<ListNode> pHead2_list = new ArrayDeque<>();
 		
 		while(pHead1!=null){
 			pHead1_list.push(pHead1);
 			pHead1 = pHead1.next;
 		}
 		
 		while(pHead2!=null){
 			pHead2_list.push(pHead2);
 			pHead2 = pHead2.next;
 		}
 		
 		ListNode result = null;
 		while(!pHead1_list.isEmpty()&&!pHead2_list.isEmpty()){
 			if(pHead1_list.peek()!=pHead2_list.peek())
 				return result;
 			else{
 				result = pHead1_list.pop();
 				pHead2_list.pop();
 			}
 		}
 		
 		return result;
    }
	
	public static void main(String[] args){
		ArrayDeque arrayDeque = new ArrayDeque<>();
		arrayDeque.push(0);
		arrayDeque.push(1);
		arrayDeque.push(2);
		
//		arrayDeque.add(0);
//		arrayDeque.add(1);
//		arrayDeque.add(2);
		
//		System.out.println(arrayDeque.peek());
//		System.out.println(arrayDeque.peekFirst());
//		System.out.println(arrayDeque.peekLast());
//		System.out.println(arrayDeque.getFirst());
//		System.out.println(arrayDeque.getLast());
//		System.out.println(arrayDeque.poll());
		
		
	}
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
