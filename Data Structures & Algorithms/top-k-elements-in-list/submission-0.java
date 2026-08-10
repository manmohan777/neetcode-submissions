class Solution {
       class Pair {
        int key;
        int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey() { return key; }
        public int getValue() { return value; }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Pair> list=new ArrayList<Pair>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }
        list.sort((a,b)->b.getValue()-a.getValue());
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i).getKey();
        }
        return res;
    }
}

