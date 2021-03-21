class Solution {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        if(s.length()<=1){
            return s;
        }
        int ans=1;
        String result=s.substring(0,1);
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>i;j--){
                if(isPa(s,i,j)){
                    if(j-i+1>ans){
                        result=s.substring(i,j+1);
                        ans=j-i+1;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public boolean isPa(String s, int a, int b){
        while(b-a>0){
            if(s.charAt(a)!=s.charAt(b)) return false;
            a++; b--;
        }
        return true;
    }



    public String longestPalindrome1(String s) {
        if(s==null){
            return null;
        }
        if(s.length()<=1){
            return s;
        }
        boolean[][] isPa=new boolean[s.length()+1][s.length()+1];
        int ans=1;
        String result=s.substring(0,1);
        for(int j=0;j<=s.length();j++){
            for(int i=0;i<=s.length()-j;i++){
                if(j<=1){
                    isPa[i][i+j]=true;
                    isPa[i+j][i]=true;
                    continue;
                }
                isPa[i][i+j]=isPa[i+1][i+j-1]&&s.charAt(i)==s.charAt(i+j-1);
                isPa[i+j][i]=isPa[i][i+j];
                if(isPa[i][i+j]){
                    if(j+1>ans){
                        ans=j+1;
                        result=s.substring(i,i+j);
                    }
                }
            }
        }
        return result;
    }


    public String longestPalindrome2(String s) {
        if(s==null||s.isEmpty()) return "";
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int i1=expandAroundCenter(s,i,i);
            int i2=expandAroundCenter(s,i,i+1);
            int len=Math.max(i1,i2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s,int left,int right){
        int L=left;
        int R=right;
        while(L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
