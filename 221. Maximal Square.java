class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=Math.max(m,n);
        if(max==1){
            return (matrix[0][0]=='1')?1:0;
        }
        int[][] temp=new int[m][n];
        max=0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1||j==n-1){
                    temp[i][j]=(matrix[i][j]=='1')?1:0;
                    max=Math.max(max,temp[i][j]);
                    continue;
                }
                if(matrix[i][j]=='0'){
                    continue;
                }
                if(temp[i+1][j]==temp[i][j+1]){
                    char pro=matrix[i+temp[i+1][j]][j+temp[i+1][j]];
                    temp[i][j]=(pro=='0')?(temp[i+1][j]):(temp[i+1][j]+1);
                    max=Math.max(max,temp[i][j]);
                }else{
                    temp[i][j]=Math.min(temp[i+1][j],temp[i][j+1])+1;
                }
            }
        }
        return max*max;
    }
}
