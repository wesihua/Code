package 剑指offer;

public class 第17题_合并两个排序的链表 {
	public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
			temp =temp.next;
        }
        
        if(list1!=null){
            temp.next = list1;
        }
        else if(list2!=null){
            temp.next = list2;
        }
        
        return head.next;
    }
}
