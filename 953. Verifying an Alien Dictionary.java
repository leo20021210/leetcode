class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] alpha=new char[order.length()];
        for(int i=0;i<order.length();i++){
            alpha[i]=order.charAt(i);
        }
        for(int i=0;i<words.length-1;i++){
            String temp1=words[i];
            String temp2=words[i+1];
            int j=0;
            while(j<temp1.length()||j<temp2.length()){
                if(j>=temp1.length()||j>=temp2.length()){
                    if(temp2.length()<temp1.length()) return false;
                    break;
                }
                if(find(temp1.charAt(j),alpha)>find(temp2.charAt(j),alpha)) return false;
                if(find(temp1.charAt(j),alpha)<find(temp2.charAt(j),alpha)) break;
                j++;
            }
        }
        return true;
    }

    public int find(char a, char[] order){
        int i;
        for(i=0;i<order.length;i++){
            if (order[i]==a) return i;
        }
        return 0;
    }
}
