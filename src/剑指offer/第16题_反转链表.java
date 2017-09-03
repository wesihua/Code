package 剑指offer;

public class 第16题_反转链表 {
	/**
	 * 
	 * @param head
	 * @return
	 */
	public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
		ListNode reverseHead = head;
        ListNode head_next = head.next;
        reverseHead.next = null;
        while(head_next!=null){
            ListNode temp = head_next.next;
            head_next.next = reverseHead;
            reverseHead = head_next;
            head_next = temp;
        }
        return reverseHead;
    }
}
