class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int len=0;
        ListNode ptr=head;
        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        ptr=head;
        int[] result=new int[len];
        int i=0;
        while(ptr!=null){
            ListNode ptr2=ptr.next;
            while(ptr2!=null){
                if(ptr2.val>ptr.val){
                    result[i]=ptr2.val;
                    break;
                }
                ptr2=ptr2.next;
            }
            i++;
            ptr=ptr.next;
        }
        return result;
    }
}

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int[] arr=toArray(head);
        Stack<Integer> stack= new Stack<>();
        int[] result=new int[arr.length];
        ListNode ptr=head;
        for(int i=0;i<arr.length;i++){
            while((!stack.isEmpty())&&arr[i]>arr[stack.peek()]){
                result[stack.pop()]=arr[i];
            }
            stack.push(i);
        }
        return result;
    }

    private int[] toArray(ListNode head){
        ListNode ptr=head;
        int len=0;
        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        int[] result=new int[len];
        int i=0;
        ptr=head;
        while(ptr!=null){
            result[i]=ptr.val;
            i++;
            ptr=ptr.next;
        }
        return result;
    }
}
