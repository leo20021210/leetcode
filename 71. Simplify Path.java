class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<String>();
        String[] comp=path.split("/");
        for(String ele:comp){
            if(ele.equals(".")||ele.isEmpty()){
            }else if(ele.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(ele);
            }
        }
        String res="";
        for(String s:stack){
            System.out.println(s);
            res=res+"/"+s;
        }
        return res.equals("")?"/":res;
    }
}
