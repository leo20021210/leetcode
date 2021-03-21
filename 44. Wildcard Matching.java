class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        if(p.charAt(0)=='*'){
            if(s.isEmpty()){
                return isMatch(s,p.substring(1));
            }
            return isMatch(s.substring(1),p)||isMatch(s,p.substring(1));
        }else if(!s.isEmpty()&&p.charAt(0)=='?'){
            return isMatch(s.substring(1),p.substring(1));
        }else{
            return !s.isEmpty()&&s.charAt(0)==p.charAt(0)&&isMatch(s.substring(1),p.substring(1));
        }
    }

    public boolean isMatch1(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        if (p.equals(s) || p.equals("*")) return true;
        boolean[][] temp=new boolean[s.length()+1][p.length()+1];
        temp[s.length()][p.length()]=true;
        for(int i=s.length();i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(p.charAt(j)=='*'){
                    if(i==s.length()){
                        temp[i][j]=temp[i][j+1];
                        continue;
                    }
                    temp[i][j]=temp[i+1][j]||temp[i][j+1];
                }else if(i<s.length()&&p.charAt(j)=='?'){
                    temp[i][j]=temp[i+1][j+1];
                }else{
                    temp[i][j]=i!=s.length()&&s.charAt(i)==p.charAt(j)&&temp[i+1][j+1];
                }
            }
        }
        return temp[0][0];
    }
}
