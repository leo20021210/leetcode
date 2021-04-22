class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        return inorder(root);
    }
    
    public List<Integer> inorder(TreeNode root){
        if(root==null){
            return null;
        }
        List<Integer> left=inorder(root.left);
        List<Integer> right=inorder(root.right);
        List<Integer> temp=new ArrayList<Integer>();
        if(left!=null){
			for(int i:left){
				temp.add(i);
			}
		}
        temp.add(root.val);
        if(right!=null){
			for(int i:right){
				temp.add(i);
			}
        }
        return temp;
    }
}