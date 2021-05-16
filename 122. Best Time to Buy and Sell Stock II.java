class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int pivot=0;
        while(pivot<prices.length-1){
            int j=pivot;
            while(j<prices.length-1&&prices[j]>prices[j+1]){
                j++;
            }
            pivot=j;
            while(j<prices.length-1&&prices[j]<=prices[j+1]){
                j++;
            }
            res=res+prices[j]-prices[pivot];
            pivot=j;
        }
        return res;
    }
    public int maxProfit1(int[] prices) {
        int res=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                res+=prices[i+1]-prices[i];
            }
        }
        return res;
    }
}
