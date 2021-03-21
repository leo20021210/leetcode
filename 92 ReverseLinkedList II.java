class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>=n){
            return head;
        }
        ListNode temp1=head;
        ListNode temp2=head;
        for(int i=1;i<m;i++){
            temp1=temp1.next;
        }
        for(int i=1;i<n;i++){
            temp2=temp2.next;
        }
        int temp=temp1.val;
        temp1.val=temp2.val;
        temp2.val=temp;
        reverseBetween(head,m+1,n-1);
        return head;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
      if(m>=n){
          return head;
      }
      ListNode pre=head;
      ListNode cur=head.next;
      if(m==1){
          pre=null;
          cur=head;
      }
      for(int i=2;i<m;i++){
          pre=pre.next;
          cur=cur.next;
      }
      ListNode con=pre;
      ListNode tail=cur;
      ListNode third=null;
      for(int i=m;i<=n;i++){
          third=cur.next;
          cur.next=pre;
          pre=cur;
          cur=third;
      }
      if(con==null){
          tail.next=cur;
          head=pre;
          return head;
      }
      con.next=pre;
      tail.next=cur;
      return head;
    }
}
