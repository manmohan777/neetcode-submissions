class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
       Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
       int[][] queriesWithIdx = new int[queries.length][2];
       for(int i = 0; i<queries.length; i++){
        queriesWithIdx[i][0] = queries[i];
        queriesWithIdx[i][1] = i;
       }
       Arrays.sort(queriesWithIdx,(a, b)-> a[0]-b[0]); 
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[1]-a[0])-(b[1]-b[0]));
       int i =0;
       int res[] = new int[queries.length];
       for(int[] query:queriesWithIdx){
            while(i<intervals.length && intervals[i][0] <= query[0]){
                pq.add(intervals[i]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < query[0]){
                int temp[] = pq.poll();
            }
            if(pq.isEmpty()){
                res[query[1]] = -1;
            }else{
                int[] temp =pq.peek();
                res[query[1]] = temp[1]-temp[0]+1;
            }
       }
        return res;
    }
}
