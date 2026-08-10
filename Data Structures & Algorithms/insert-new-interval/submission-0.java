class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      
        ArrayList<int[]> res=new ArrayList();
        for(int i=0;i<intervals.length;i++){
            int start= newInterval[0];
            int end= newInterval[1];
            int[] current=intervals[i];
            if(end<current[0]){
                res.add(newInterval);
                for(int j=i;j<intervals.length;j++){
                    int c[]=intervals[j];
                    res.add(c);
                }
                return res.toArray(new int[res.size()][]);
            }
            if(current[1]<start){
                res.add(current);
            }
            else{
                newInterval[0]=Math.min(start,current[0]);
                newInterval[1]=Math.max(end,current[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
