class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res= new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(newInterval[1]< intervals[i][0]){
                res.add(newInterval);
                for(int j = i; j < n; j++){
                    res.add(new int[]{intervals[j][0],intervals[j][1]});
                }
                int[][] resInt = new int[res.size()][2];
                for(int k = 0; k< res.size(); k++){
                    resInt[k] = res.get(k);
                } 
                return resInt; 
            }
            else if(newInterval[0] > intervals[i][1] ){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }else {
                newInterval[0]  = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
        }
        res.add(newInterval);
        int[][] resInt = new int[res.size()][2];
        for(int i = 0; i< res.size(); i++){
            resInt[i] = res.get(i);
        } 
        return resInt;   
    }
}
