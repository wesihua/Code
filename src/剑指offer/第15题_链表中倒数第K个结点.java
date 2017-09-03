package 剑指offer;

public class 第15题_链表中倒数第K个结点 {
	/**
	 * 用两个指针，一个先走K步，然后两个指针一起向前走，先走的指针走到尽头时，后走的指针就在倒数第K个结点
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode first = head;
        for(int i=0;i<k;i++){
            if(first==null)
                return null;
            first = first.next;
        }
        ListNode second = head;
        
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        
        return second;
    }
}
