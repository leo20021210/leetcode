class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.equals("0")){
            return num2;
        }
        if(num2.equals("0")){
            return num1;
        }
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        System.out.println(num1+" "+num2);
        int i=num1.length()-1;
        int j=num2.length()-1;
        Boolean digit=false;
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(i>=0&&j>=0){
            System.out.println("Here");
            Character temp1=num1.charAt(i);
            String t1=temp1.toString();
            int a=Integer.valueOf(t1);
            Character temp2=num2.charAt(j);
            String t2=temp2.toString();
            int b=Integer.valueOf(t2);
            if(digit){
                int temp=a+b+1;
                if(temp>=10){
                    digit=true;
                    temp=temp-10;
                }else{
                    digit=false;
                }
                res.add(temp);
            }else{
                int temp=a+b;
                if(temp>=10){
                    digit=true;
                    temp=temp-10;
                }else{
                    digit=false;
                }
                res.add(temp);
            }
            i--; j--;
        }
        System.out.println("out");
        while(i>=0){
            System.out.println("round");
            Character temp1=num1.charAt(i);
            String t1=temp1.toString();
            int a=Integer.valueOf(t1);
            if(digit){
                a=a+1;
            }
            if(a>=10){
                digit=true;
                res.add(a-10);
            }else{
                digit=false;
                res.add(a);
            }
            i--;
        }
        if(digit){
            res.add(1);
        }
        String ans="";
        for(int i1=res.size()-1;i1>=0;i1--){
            ans=ans+res.get(i1).toString();
        }
        return ans;
    }
}
