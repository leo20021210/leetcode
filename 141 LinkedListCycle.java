class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
    }
 }

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode first=head;
        ListNode second=head;
        while(second.next!=null&&second.next.next!=null&&second.next.next!=first.next){
            first=first.next;
            second=second.next.next;
        }
        if(second.next==null||second.next.next==null){
            return false;
        }
        return true;
    }

    public boolean hasCycle2(ListNode head) {
      Set<ListNode> seen=new HashSet<ListNode>();
      ListNode temp=head;
      while(temp!=null){
          if(seen.contains(temp)){
              return true;
          }
          seen.add(temp);
          temp=temp.next;
      }
      return false;
    }
}
