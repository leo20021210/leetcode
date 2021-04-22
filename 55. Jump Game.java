class Solution {
    public boolean canJump(int[] nums) {
        boolean[] jumps=new boolean[nums.length];
        jumps[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            jumps[i]=false;
            for(int j=1;j<=nums[i];j++){
                if(jumps[j+i]){
                    jumps[i]=true;
                    break;
                }
            }
        }
        return jumps[0];
    }
	
	
    public boolean canJump(int[] nums) {
        int last=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=last){
                last=i;
            }
        }
        return last==0;
    }
}