class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        Boolean first=((!s.isEmpty())&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'));
        if(p.length()>=2&&p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||(first&&isMatch(s.substring(1),p));
        }else{
            return first&&(isMatch(s.substring(1),p.substring(1)));
        }
    }
    
    public boolean isMatch2(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()]=true;
        for(int i=s.length();i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                Boolean first=((i<s.length())&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'));
                if(j+1<p.length()&&p.charAt(j+1)=='*'){
                    dp[i][j]=dp[i][j+2]||(first&&dp[i+1][j]);
                }else{
                    dp[i][j]=first&&(dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
