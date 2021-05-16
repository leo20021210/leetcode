class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int height=matrix.length;
        int width=matrix[0].length;
        int[][] widths=new int[height][width];
        int max=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(matrix[i][j]=='1'){
                    widths[i][j]=j==0?1:widths[i][j-1]+1;
                }
            }
        }
        for(int i=0;i<width;i++){
            Deque<Integer> stack=new ArrayDeque<Integer>();
            stack.push(-1);
            for(int j=0;j<height;j++){
                while(stack.peek()!=-1&&widths[stack.peek()][i]>=widths[j][i]){
                    max=Math.max(max,widths[stack.pop()][i]*(j-stack.peek()-1));
                }
                stack.push(j);
            }
            while(stack.peek()!=-1){
                max=Math.max(max,widths[stack.pop()][i]*(height-stack.peek()-1));
            }
        }
        return max;
    }
}