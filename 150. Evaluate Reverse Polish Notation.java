class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<Integer>();
        for(String a:tokens){
            if(!a.equals("+")&&!a.equals("-")&&!a.equals("*")&&!a.equals("/")){
                int res=0;
                int size=1;
                if(a.charAt(0)=='-'){
                    for(int i=a.length()-1;i>=1;i--){
                        int temp=a.charAt(i)-'0';
                        res+=temp*size;
                        size*=10;
                    }
                    res*=-1;
                }else{
                    for(int i=a.length()-1;i>=0;i--){
                        int temp=a.charAt(i)-'0';
                        res+=temp*size;
                        size*=10;
                    }
                }
                stack.push(res);
            }else{
                int o2=stack.pop();
                int o1=stack.pop();
                int res=0;
                if(a.equals("+")){
                    res=o1+o2;
                }else if(a.equals("-")){
                    res=o1-o2;
                }else if(a.equals("*")){
                    res=o1*o2;
                }else if(a.equals("/")){
                    res=o1/o2;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}