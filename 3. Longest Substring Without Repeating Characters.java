class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> strings=new HashSet<Character>();
        int ans=0, i=0, j=0;
        while(i<s.length()&&j<s.length()){
            if(!strings.contains(s.charAt(j))){
                strings.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                strings.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> chars=new HashMap<Character, Integer>();
        int ans=0, i=0;
        for(int j=0;j<s.length();j++){
            if(chars.containsKey(s.charAt(j))){
                i=Math.max(i,chars.get(s.charAt(j)));
            }
            ans=Math.max(ans,j-i+1);
            chars.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
