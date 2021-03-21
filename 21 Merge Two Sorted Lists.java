class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode head=new ListNode(1);
        ListNode add=head;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<temp2.val){
                add.next=new ListNode(temp1.val);
                temp1=temp1.next;
            }else{
                add.next=new ListNode(temp2.val);
                temp2=temp2.next;
            }
            add=add.next;
        }
        if(temp1==null){
            add.next=temp2;
        }else{
            add.next=temp1;
        }
        return head.next;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val>l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
        l1.next=mergeTwoLists(l2,l1.next);
        return l1;
    }
}
