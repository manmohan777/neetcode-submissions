class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b-a);
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int a=pq.poll();
            int b= pq.poll();
            if(a!=b){
                pq.offer(a-b);
            }
        }
        return pq.size()==0 ? 0:pq.peek();
    }
}
