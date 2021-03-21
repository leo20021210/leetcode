class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(!dp[j]) continue;
                String temp=s.substring(j,i);
                boolean flag=false;
                for(String a:wordDict){
                    if(temp.equals(a)){
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
