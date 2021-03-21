class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=0;
        int len2=0;
        ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1!=null){
            temp1=temp1.next;
            len1++;
        }
        while(temp2!=null){
            temp2=temp2.next;
            len2++;
        }
        if(len1<len2){
            ListNode temp=l1;
            l1=l2;
            l2=temp;
            int a=len1;
            len1=len2;
            len2=a;
        }
        temp1=l1;
        temp2=l2;
        ListNode ans=new ListNode();
        while(len1>len2){
            ListNode temp=new ListNode(temp1.val);
            temp.next=ans;
            ans=temp;
            temp1=temp1.next;
            len1--;
        }
        while(len2>0){
            ListNode temp=new ListNode(temp1.val+temp2.val);
            temp.next=ans;
            ans=temp;
            len2--;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        ListNode result=null;
        ListNode cur=ans;
        boolean digit=false;
        while(cur!=null){
            int val=cur.val;
            if(digit){
                val++;
            }
            if(val>=10){
                val=val-10;
                digit=true;
            }else{
                digit=false;
            }
            ListNode temp=new ListNode(val);
            temp.next=result;
            result=temp;
            cur=cur.next;
        }
        if(digit){
            ListNode temp=new ListNode(1);
            temp.next=result;
            result=temp;
        }
        if(result.val==0){
        return result.next;}
        else{return result;}
    }
}
