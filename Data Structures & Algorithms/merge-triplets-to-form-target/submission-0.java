class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] triplet) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int[] hand : triplets){
            if(hand[0]<=triplet[0] && 
            hand[1]<=triplet[1] && 
            hand[2]<=triplet[2] ){
                if(hand[0]==triplet[0]) a=true;
                if(hand[1]==triplet[1]) b=true;
                if(hand[2]==triplet[2]) c=true;
                if(a && b && c) return true;
            }
        }
        return false;
    }
}
