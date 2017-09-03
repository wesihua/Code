package leetcode;

/**
 * 
 * @author zhenlanghuo
 *
 */
public class linked_list_cycle {
	/**
	 * 	题目描述：
	 	Given a linked list, determine if it has a cycle in it.
		Follow up:
		Can you solve it without using extra space?
	 * @param head
	 * @return
	 * 快慢指针相遇说明有环
	 */
	public boolean hasCycle(ListNode head){
		if(head==null||head.next==null)
			return false;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				return true;
		}
		
		return false;
	}
	
	/**
	 * 	题目描述：
	 	Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
		Follow up:
		Can you solve it without using extra space?
	 * @param head
	 * @return
	 * 快慢指针相遇说明有环，在快慢指针相遇的时候，一个指针从头开始，一个指针从相遇的地方开始，以相同速度向前走，相遇的地方就是环开始的地方
	 * https://www.nowcoder.com/questionTerminal/6e630519bf86480296d0f1c868d425ad
	 */
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null)
			return null;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				while(head!=slow){
					head = head.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
    }
}
