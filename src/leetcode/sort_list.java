package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 	题目描述：
 	Sort a linked list in O(n log n) time using constant space complexity.
 * @author zhenlanghuo
 *
 */
public class sort_list {
	
//	//归并排序（单链表的归并排序）
//	public ListNode sortList(ListNode head){
//		if(head==null || head.next==null)
//			return head;
//		ListNode mid = getMid(head);
//		ListNode right = sortList(mid.next);
//		mid.next = null;
//		ListNode left = sortList(head);
//		return mergerSort(left, right);
//	}
//	
	public ListNode mergerSort(ListNode left,ListNode right){
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while(left!=null && right!=null){
			if(left.val<right.val){
				temp.next = left;
				left = left.next;
			}
			else{
				temp.next = right;
				right = right.next;
			}
			temp = temp.next;
		}
		
		if(left!=null){
			temp.next = left;
		}
		else if(right != null){
			temp.next = right;
		}
		
		return head.next;
	}
//	
//	//利用快慢指针查找出中间的指针
//	public ListNode getMid(ListNode head){
//		if(head == null)
//			return head;
//		ListNode fast = head;
//		ListNode slow = head;
//		while(fast.next!=null && fast.next.next!=null){
//			fast = fast.next.next;
//			slow = slow.next;
//		}
//		return slow;
//	}
	
//	//归并排序(转化为数组形式数组形式)
//	public ListNode sortList(ListNode head) {
//        List<ListNode> listNodes = new ArrayList<>();
//        while(head!=null){
//        	listNodes.add(head);
//        	head = head.next;
//        }
//		
//        mergerSort(listNodes,0,listNodes.size()-1);
//        
//        for(int i=0;i<listNodes.size()-1;i++){
//        	listNodes.get(i).next = listNodes.get(i+1);
//        }
//        listNodes.get(listNodes.size()-1).next = null;
//        
//		return listNodes.get(0);
//    }
//	
//	public static void mergerSort(List<ListNode> list,int start,int end){
//		if(start-end == 0)
//			return;
//		int mid = (start+end)/2;
//		mergerSort(list, start, mid);
//		mergerSort(list, mid+1, end);
//		List<ListNode> temp = new ArrayList<>();
//		for(int i=start,j=mid+1;i<=mid||j<=end;){
//			if(i>mid){
//				temp.add(list.get(j));
//				j++;
//			}
//			else if(j>end){
//				temp.add(list.get(i));
//				i++;
//			}
//			else if(list.get(i).val<list.get(j).val){
//				temp.add(list.get(i));
//				i++;
//			}
//			else{
//				temp.add(list.get(j));
//				j++;
//			}
//		}
//		
//		for(int i=0;i<temp.size();i++){
//			list.set(i+start, temp.get(i));
//		}
//	}
	
//	//直接使用Collections库的排序接口
//	public ListNode sortList(ListNode head) {
//        List<ListNode> listNodes = new ArrayList<>();
//        while(head!=null){
//        	listNodes.add(head);
//        	head = head.next;
//        }
//		
//        if(listNodes.size() == 0)
//            return null;
//        
//        Collections.sort(listNodes,new Comparator<ListNode>() {
//        	public int compare(ListNode o1,ListNode o2){
//        		return Integer.valueOf(o1.val).compareTo(Integer.valueOf(o2.val));
//        	}
//		});
//        
//        for(int i=0;i<listNodes.size()-1;i++){
//        	listNodes.get(i).next = listNodes.get(i+1);
//        }
//        listNodes.get(listNodes.size()-1).next = null;
//        
//		return listNodes.get(0);
//    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
