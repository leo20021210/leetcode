class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        DFS(root,0,res);
        return res;
    }
    
    private void DFS(TreeNode temp,int level,List<List<Integer>> res){
        if(level>=res.size()){
            LinkedList<Integer> list=new LinkedList<Integer>();
            list.add(temp.val);
            res.add(list);
        }else{
            if(level%2==0){
                res.get(level).add(temp.val);
            }else{
                res.get(level).add(0,temp.val);
            }
        }
        if(temp.left!=null){
            DFS(temp.left,level+1,res);
        }
        if(temp.right!=null){
            DFS(temp.right,level+1,res);
        }
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        int level=0;
        Stack<TreeNode> last=new Stack<TreeNode>();
        last.push(root);
        while(!last.isEmpty()){
            Stack<TreeNode> temp=new Stack<TreeNode>();
            ArrayList<Integer> cur=new ArrayList<Integer>();
            level++;
            while(!last.isEmpty()){
                TreeNode t=last.pop();
                cur.add(t.val);
                if(level%2==0){
                    if(t.right!=null){
                        temp.push(t.right);
                    }
                    if(t.left!=null){
                        temp.push(t.left);
                    }
                }else{
                    if(t.left!=null){
                        temp.push(t.left);
                    }
                    if(t.right!=null){
                        temp.push(t.right);
                    }
                }
            }
            last=temp;
            if(!cur.isEmpty()){
                res.add(cur);
            }
        }
        return res;
    }
}