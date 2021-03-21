class Solution {
  public int numDecodings(String s) {
      if(s==null) return 0;
      return numDecodings1(s);
  }


  public int numDecodings1(String s) {
      if(s.equals("0")) return 0;
      if(s.length()==0) return 1;
      if(s.length()==1) return 1;
      if(s.substring(0,1).equals("0")) return 0;
      if(Integer.valueOf(s.substring(0,2))>26){
          return numDecodings1(s.substring(1));
      }
      return numDecodings1(s.substring(1))+numDecodings1(s.substring(2));
  }

    public int numDecodings1(String s) {
        if(s==null) return 0;
        if(s.equals("0")) return 0;
        if(s.length()==1) return 1;
        int[] temp=new int[s.length()+1];
        temp[s.length()-1]=s.charAt(s.length()-1)=='0'?0:1;
        temp[s.length()]=1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.substring(i,i+1).equals("0")){
                temp[i]=0;
                continue;
            }
            if(Integer.valueOf(s.substring(i,i+2))>26){
                temp[i]=temp[i+1];
                continue;
            }
            temp[i]=temp[i+1]+temp[i+2];
        }
        return temp[0];
    }


    public int numDecodings2(String s) {
        if(s==null) return 0;
        if(s.equals("0")) return 0;
        if(s.length()==1) return 1;
        int cur=s.charAt(s.length()-1)=='0'?0:1;
        int last=1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.substring(i,i+1).equals("0")){
                last=cur;
                cur=0;
                continue;
            }
            if(Integer.valueOf(s.substring(i,i+2))>26){
                last=cur;
                continue;
            }
            int temp=cur;
            cur=cur+last;
            last=temp;
        }
        return cur;
    }
}
