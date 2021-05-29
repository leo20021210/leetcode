class BSTIterator {
    Stack<TreeNode> stack=new Stack<TreeNode>();
    TreeNode rootNode=null;
    TreeNode temp=null;

    public BSTIterator(TreeNode root) {
        stack=new Stack<TreeNode>();
        rootNode=root;
        temp=null;
    }
    
    public int next() {
        if(temp==null){
            temp=rootNode;
            while(temp.left!=null){
                stack.push(temp);
                temp=temp.left;
            }
            return temp.val;
        }
        if(temp.right!=null){
            temp=temp.right;
            while(temp.left!=null){
                stack.push(temp);
                temp=temp.left;
            }
            return temp.val;
        }
        while(!stack.isEmpty()){
            TreeNode last=stack.pop();
            if(last.val>=temp.val){
                temp=last;
                break;
            }
        }
        return temp.val;
    }
    
    public boolean hasNext() {
        if(temp==null){
            return rootNode!=null;
        }
        if(temp.right!=null){
            return true;
        }
        boolean hasNext=false;
        Stack<TreeNode> tempStack=new Stack<TreeNode>();
        while(!stack.isEmpty()){
            TreeNode last=stack.pop();
            tempStack.push(last);
            if(last.val>=temp.val){
                hasNext=true;
                break;
            }
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return hasNext;
    }
}