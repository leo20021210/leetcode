class Solution {
    public int jump(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int last=nums.length-1;
        int count=0;
        while(last>nums[0]){
            int temp=last;
            for(int j=last;j>=0;j--){
                if(nums[j]>=last-j){
                    temp=j;
                }
            }
            count++;
            if(temp!=last){
                last=temp;
            }else{
                break;
            }
        }
        return count+1;
    }
}
