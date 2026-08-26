class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a,b)->{
                int distanceToA = (a[0]*a[0] + a[1] * a[1]);
                int distanceToB = (b[0]*b[0] + b[1] * b[1]);
             return   distanceToB - distanceToA;    
            });
            for(int[] point : points){
                pq.offer(point);
                if(pq.size() > k)
                    pq.poll();
            }
            int res[][] = new int[pq.size()][2];
            int i=0;
            while(!pq.isEmpty()){
                res[i]= pq.poll();
                i++;
            }
            return  res;

    }
}
