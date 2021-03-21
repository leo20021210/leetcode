class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]+dp[i-1]>=nums[i]){
                dp[i]=nums[i]+dp[i-1];
            }else{
                dp[i]=nums[i];
            }
        }
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i]>max) max=dp[i];
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int cur=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            cur=Math.max(nums[i],nums[i]+cur);
            max=Math.max(cur,max);
        }
        return max;
    }
}
