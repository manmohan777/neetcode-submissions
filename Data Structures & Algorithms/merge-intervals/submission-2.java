class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int[] current = intervals[0];
        List<int[]> res = new ArrayList();
        for(int i = 1; i< intervals.length; i++){
            if(current[1] < intervals[i][0]){
                res.add(new int[]{current[0], current[1]});
                current = intervals[i];
            }else if(current[1] >= intervals[i][0]){
                current[1] = Math.max(intervals[i][1], current[1]);
            }
        }
        res.add(current);
        int resInt[][] = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            resInt[i] = res.get(i);
        }
        return resInt;
    }
}
