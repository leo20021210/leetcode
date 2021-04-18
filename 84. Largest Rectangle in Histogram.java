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
}
