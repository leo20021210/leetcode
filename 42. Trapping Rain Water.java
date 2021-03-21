class Solution {
    public int trap(int[] height) {
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            int leftMax=height[i];
            int rightMax=height[i];
            for(int j=i-1;j>=0;j--){
                if(height[j]>leftMax){
                    leftMax=height[j];
                }
            }
            for(int j=i+1;j<height.length;j++){
                if(height[j]>rightMax){
                    rightMax=height[j];
                }
            }
            sum=sum+Math.min(rightMax,leftMax)-height[i];
        }
        return sum;
    }

    public int trap2(int[] height) {
        int max=0;
        int index=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
                index=i;
            }
        }
        int cur=0;
        int sum=0;
        for(int i=0;i<index;i++){
            if(height[i]>cur){
                cur=height[i];
            }else{
                sum=sum+cur-height[i];
            }
        }
        cur=0;
        for(int i=height.length-1;i>index;i--){
            if(height[i]>cur){
                cur=height[i];
            }else{
                sum=sum+cur-height[i];
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        if(height==null||height.length<=1) return 0;
        int n=height.length;
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        leftmax[0]=height[0];
        rightmax[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans+Math.min(rightmax[i],leftmax[i])-height[i];
        }
        return ans;
    }
}
