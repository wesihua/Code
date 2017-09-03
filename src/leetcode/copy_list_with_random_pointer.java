package leetcode;

public class copy_list_with_random_pointer {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return null;
		
		RandomListNode tempHead = head;
		while(tempHead!=null){
        	RandomListNode temp = new RandomListNode(tempHead.label);
        	temp.next = tempHead.next;
        	tempHead.next = temp;
        	tempHead = temp.next;
        }
		
		tempHead = head;
		while(tempHead!=null){
			if(tempHead.random!=null){
				tempHead.next.random = tempHead.random.next;
			}
			tempHead = tempHead.next.next;
		}
		
		RandomListNode resultHead = head.next;
		RandomListNode tempResultHead = resultHead;
		while(tempResultHead.next!=null){
			tempResultHead.next = tempResultHead.next.next;
			tempResultHead = tempResultHead.next;
		}
		
		return resultHead;
    }
	
	public static void main(String args[]){
		RandomListNode listNode = new RandomListNode(-1);
		copyRandomList(listNode);
	}
}

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }
