class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            heap.offer(new int[]{entry.getKey(),entry.getValue()});
            if(heap.size()>k){
                heap.poll();
            }
        }
        int res[]=new int[k];
        while(k>0){
            res[k-1]=heap.poll()[0];
            k--;
        }
        return res;
    }
}

