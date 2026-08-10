class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        int[] interval = intervals[0];
        ArrayList<int[]> res=new ArrayList();
        for(int i=1;i<intervals.length;i++){
            int current[]=intervals[i];
            if(interval[1]<current[0]){
                res.add(interval);
                interval=current;
            }
            else{
                interval[0]=Math.min(current[0],interval[0]);
                interval[1]=Math.max(current[1],interval[1]);
            }
        }
        res.add(interval);
        return res.toArray(new int[0][]);
    }
}
