class Solution {
    public int longestSubarray(int[] nums, int lmt) {
        Deque<Integer> lq = new ArrayDeque<>(), rq = new ArrayDeque<>();
        int res = 0, lastValid = 0;
        for (int i = 0; i < nums.length; i++) {
            while (lq.size() > 0 && nums[lq.peekLast()] < nums[i]) lq.pollLast();
            while (rq.size() > 0 && nums[rq.peekLast()] > nums[i]) rq.pollLast();
            lq.offer(i);
            rq.offer(i);
            while (nums[lq.peek()] - nums[rq.peek()] > lmt) {
                if (lq.peek() > rq.peek()) lastValid = rq.poll() + 1;
                else lastValid = lq.poll() + 1;
            }
            res = Math.max(res, i - lastValid + 1);

        }
        return res;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int max=1;
        Boolean flag=true;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=i;k<j;k++){
                    if(Math.abs(nums[k]-nums[j])>limit){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    max=Math.max(j-i+1,max);
                }else{
                    flag=true;
                    break;
                }
            }
        }
        return max;
    }
}
