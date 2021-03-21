class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            if(sum==k){
                count++;
            }
            for(int j=1;j<nums.length-i;j++){
                sum=sum+nums[i+j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
