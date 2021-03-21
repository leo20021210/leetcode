// dfs 找到 first element
class Solution {
    ArrayList<TreeNode> nodes=new ArrayList<TreeNode>();
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null){
            return true;
        }
        find(head.val,root);
        if(nodes.isEmpty()){
            return false;
        }
        for(TreeNode node:nodes){
            if(check(head,node)){
                return true;
            }
        }
        return false;
    }

    public void find(int val, TreeNode root){
        if(root==null){
            return;
        }
        if(root.val==val){
            nodes.add(root);
        }
        find(val,root.left);
        find(val,root.right);
    }

    public boolean check(ListNode head, TreeNode found){
        if(head.next==null){
            return true;
        }
        Boolean left=false;
        Boolean right=false;
        if(found.left!=null&&head.next.val==found.left.val){
            left=check(head.next,found.left);
        }
        if(found.right!=null&&head.next.val==found.right.val){
            right=check(head.next,found.right);
        }
        return left||right;
    }
}
