class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length+2;
        int[] newnum=new int[n];
        for(int i=0;i<nums.length;i++){
            newnum[i+1]=nums[i];
        }
        newnum[0]=newnum[n-1]=1;
        int[][] memo=new int[n][n];
        for(int left=n-2;left>=0;left--){
            for(int right=left+1;right<n;right++){
                for(int i=left+1;i<right;i++){
                    memo[left][right]=Math.max(memo[left][right],newnum[left]*newnum[i]*newnum[right]+memo[left][i]+memo[i][right]);
                }
            }
        }
        return memo[0][n-1];
    }
}
