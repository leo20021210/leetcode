class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode curr=l3;
        int carry=0;
        while(temp1!=null||temp2!=null){
            int x=temp1==null?0:temp1.val;
            int y=temp2==null?0:temp2.val;
            int sum=carry+x+y;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(temp1!=null) temp1=temp1.next;
            if(temp2!=null) temp2=temp2.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return l3.next;
    }
}
