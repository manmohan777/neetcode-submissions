class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i< gas.length; i++){
            totalGas+=gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;
        int res=0; 
        int total=0;
        for(int i = 0; i < gas.length; i++){
            total += (gas[i]-cost[i]);
            if(total<0){
                res= i+1;
                total = 0;
            }
        }
        return res;
    }
}
