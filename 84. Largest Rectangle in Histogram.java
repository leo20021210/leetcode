class Solution {
    public int largestRectangleArea(int[] heights) {
      int max=0;
      for(int i=0;i<heights.length;i++){
         int min=heights[i];
         for(int j=i;j>=0;j--){
             min=Math.min(min,heights[j]);
             max=Math.max(max,(i-j+1)*min);
         }
      }
      return max;
    }
    
    
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack=new ArrayDeque<Integer>();
        stack.push(-1);
        int length=heights.length;
        for(int i=0;i<length;i++){
            while(stack.peek()!=-1&&heights[stack.peek()]>=heights[i]){
                int cur=heights[stack.pop()];
                maxArea=Math.max(maxArea,cur*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int cur=heights[stack.pop()];
            maxArea=Math.max(maxArea,cur*(length-stack.peek()-1));
        }
        return maxArea;
    }
}
