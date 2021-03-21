class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> size=binaryMatrix.dimensions();
        int row=size.get(0);
        int column=size.get(1);
        int ans=column;
        for(int i=0;i<row;i++){
            while(ans>0&&binaryMatrix.get(i,ans-1)==1){
                ans--;
            }
        }
        if(ans==column){
            return -1;
        }else{
            return ans;
        }
    }
}
