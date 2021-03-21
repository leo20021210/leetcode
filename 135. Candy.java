class Solution {
    public int candy(int[] ratings) {
        int ans=0;
        for(int i=0;i<ratings.length;i++){
            int j=i;
            while(j>0&&ratings[j]>ratings[j-1]){
                j--;
            }
            int k=i;
            while(k<ratings.length-1&&ratings[k]>ratings[k+1]){
                k++;
            }
            ans=ans+Math.max(i-j+1,k-i+1);
        }
        return ans;
    }

    public int candy1(int[] ratings) {
        int[] left2right=new int[ratings.length];
        int[] right2left=new int[ratings.length];
        Arrays.fill(left2right,1);
        Arrays.fill(right2left,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                left2right[i]=left2right[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                right2left[i]=right2left[i+1]+1;
            }
        }
        int sum=0;
        for(int i=0;i<ratings.length;i++){
            sum=sum+Math.max(right2left[i],left2right[i]);
        }
        return sum;
    }


    public int candy2(int[] ratings) {
        int[] candies=new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                candies[i]=candies[i-1]+1;
            }
        }
        int sum=candies[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                candies[i]=Math.max(candies[i+1]+1,candies[i]);
            }
            sum=sum+candies[i];
        }
        return sum;
    }
}
