class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return is(head,1,count);
    }

    public boolean is(ListNode head, int m, int n){
        if(m>=n){
            return true;
        }
        ListNode a=head;
        ListNode b=head;
        for(int i=1;i<m;i++){
            a=a.next;
        }
        for(int i=1;i<n;i++){
            b=b.next;
        }
        return is(head,m+1,n-1)&&a.val==b.val;
    }
}
