class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : hand)
            count.put(n, 1 + count.getOrDefault(n, 0));
        Arrays.sort(hand);
        for(int card: hand){
            if(count.get(card)>0){
                for(int i = card; i<card+groupSize; i++){
                    if(count.getOrDefault(i,0)==0) return false;
                    count.put(i,count.get(i)-1);
                }
            }
        }
        return true;
        
    }
}
