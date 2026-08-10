class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        int res=0;
        for(int num : nums){
            if(!map.containsKey(num)){
                int left= map.getOrDefault(num-1,0);
                int right= map.getOrDefault(num+1,0);
                int currentSum=left+right+1;
                map.put(num,currentSum);
                map.put(num-left,currentSum);
                map.put(num+right,currentSum);
                res=Math.max(res,currentSum);
            }
        }
        return res;
    }
}
