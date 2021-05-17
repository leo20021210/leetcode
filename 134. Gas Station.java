class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int remain=gas[i];
            int j=i==gas.length-1?0:i+1;
            while(j!=i){
                if(j==0){
                    remain=remain-cost[gas.length-1];
                    if(remain>=0){
                       remain+=gas[j];
                    }else{
                        break;
                    }
                }else{
                    remain=remain-cost[j-1];
                    if(remain>=0){
                       remain+=gas[j];
                    }
                    else{
                        break;
                    }
                }
                if(j==gas.length-1){
                    j=0;
                }else{
                    j++;
                }
            }
            if(j==0){
                remain=remain-cost[gas.length-1];
            }else{
                remain=remain-cost[j-1];
            }
            if(j==i&&remain>=0){
                return i;
            }
        }
        return -1;
    }
	
	public int canCompleteCircuit1(int[] gas, int[] cost) {
        int cur=0;
        int total=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            cur+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(cur<0){
                start=i+1;
                cur=0;
            }
        }
        return total<0?-1:start;
    }
}