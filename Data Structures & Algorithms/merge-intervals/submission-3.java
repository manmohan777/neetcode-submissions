class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList();
        int[] current = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(current[1] < intervals[i][0]){
                res.add(current);
                current = intervals[i];
            }else{
                current[0] = Math.min(current[0], intervals[i][0]);
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        res.add(current);
        int[][] resArray = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            resArray[i]=res.get(i);
        }
        return resArray;
    }
}
