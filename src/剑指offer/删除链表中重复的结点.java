package 剑指offer;


public class 删除链表中重复的结点 {
	public static ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead==null||pHead.next==null)
            return pHead;
		
        ListNode tempHead = pHead;
        ListNode temp = new ListNode(0);
        while(isHeadRepeat(tempHead,temp)){
			tempHead = temp.next;
        }
        
        pHead = tempHead;
        
        while(tempHead!=null&&tempHead.next!=null){
        	ListNode tempHead_1 = tempHead.next;
            while(isHeadRepeat(tempHead_1,temp)){
				tempHead_1 = temp.next;
        	}
            tempHead.next = tempHead_1;
            tempHead = tempHead.next;
        }
        
        return pHead;
    }
    
    public static boolean isHeadRepeat(ListNode tempHead,ListNode result){
    	result.next = tempHead;
    	if(tempHead==null)
    		return false;
        boolean isHeadRepeat = false;
        while(tempHead.next!=null){
            if(tempHead.val==tempHead.next.val){
                tempHead = tempHead.next;
                isHeadRepeat = true;
            }
            else{
            	result.next = tempHead.next;
                return isHeadRepeat;
            }   
        }
        
        result.next = null;
        return isHeadRepeat;
    }
    
    public static void main(String[] args){
    	ListNode node = new ListNode(1);
    	ListNode head = node;
    	node.next = new ListNode(1);
    	node = node.next;
    	node.next = new ListNode(1);
    	node = node.next;
    	node.next = new ListNode(1);
    	node = node.next;
    	node.next = new ListNode(1);
    	node = node.next;
    	node.next = new ListNode(1);
    	node = node.next;
    	node.next = new ListNode(1);
    	node = node.next;
    	node.next = new ListNode(1);
    	node = node.next;
    	
    	ListNode result = deleteDuplication(head);
    	
    	while(result!=null){
    		System.out.print(result.val+"->");
    		result = result.next;
    	}
    	System.out.println();
    		
    }
}
