class Solution {
    public int numComponents(ListNode head, int[] G) {
        if(head==null||G.length==0){
            return 0;
        }
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            boolean flag1=true;
            boolean flag2=true;
            for(int i=0;i<G.length;i++){
                if(G[i]==temp.val){
                    flag1=false;
                    break;
                }
            }
            if(temp.next!=null){
                for(int i=0;i<G.length;i++){
                    if(G[i]==temp.next.val){
                        flag2=false;
                        break;
                    }
                }
            }
            if(!flag1&&flag2){
                count++;
            }
            temp=temp.next;
        }
        return count;
    }
}
