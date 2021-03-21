public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        while(second.next!=null&&second.next.next!=null&&second.next.next!=first.next){
            first=first.next;
            second=second.next.next;
        }
        if(second.next==null||second.next.next==null){
            return null;
        }
        first=first.next;
        second=head;
        while(!first.equals(second)){
            first=first.next;
            second=second.next;
        }
        return first;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> seen=new HashSet<ListNode>();
        ListNode temp=head;
        while(temp!=null){
            if(seen.contains(temp)){
                return temp;
            }
            seen.add(temp);
            temp=temp.next;
        }
        return null;
    }
}
