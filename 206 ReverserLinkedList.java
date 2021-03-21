class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }

    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode cur=head;
        ListNode pre=null;
        ListNode third=null;
        while(cur.next!=null){
            third=cur.next;
            cur.next=pre;
            pre=cur;
            cur=third;
        }
        cur.next=pre;
        return cur;
    }
}
