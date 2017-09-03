package leetcode;

import java.util.ArrayList;

/**
 * 	
 *  题目描述：
  	Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	You must do this in-place without altering the nodes' values.
	For example,
	Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * @author zhenlanghuo
 *
 */
public class reorder_list {
	public static void main(String[] args){
		ListNode head = null;
//		ListNode head = new ListNode(0);
//		ListNode temp = head;
//		for(int i=1;i<=2;i++){
//			temp.next = new ListNode(i);
//			temp = temp.next;
//		}
		
		reorder_list reorder_list = new reorder_list();
		reorder_list.reorderList(head);
		
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public void reorderList(ListNode head){
		ArrayList<ListNode> list = new ArrayList<>();
		while(head!=null){
			list.add(head);
			head = head.next;
		}
		
		if(list.size() == 0)
			head = null;
		else{
			int n = list.size()-1;
			ArrayList<Integer> reorderIndex = new ArrayList<>();
			for(int i=0,j=0;j<=n;){
				if(j<=n){
					reorderIndex.add(i);
					j++;
				}
				if(j<=n){
					reorderIndex.add(n-i);
					j++;
				}
				i++;
			}
			
			head = list.get(0);
			ListNode temp = head;
			
			for(int i=1;i<reorderIndex.size();i++){
				temp.next = list.get(reorderIndex.get(i));
				temp = temp.next;
			}
			temp.next = null;
		}
	}
}
