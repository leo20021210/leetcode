class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0;
        for(int i=0;i<=k;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                sum=sum+cardPoints[j];
            }
            for(int j=cardPoints.length-1;j>=cardPoints.length-(k-i);j--){
                sum=sum+cardPoints[j];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }


    public int maxScore1(int[] cardPoints, int k) {
        int max=0;
        for(int i=0;i<k;i++){
            max=max+cardPoints[i];
        }
        int sum=max;
        for(int i=k-1;i>=0;i--){
            sum=sum-cardPoints[i]+cardPoints[cardPoints.length-(k-i)];
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}
