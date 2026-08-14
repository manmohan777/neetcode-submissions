class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //maxrate = maxvalue;
        //minRate = minValue;
        int l = 1;
        int r = 0;
        for(int pile: piles){
            
            r=Math.max(r,pile);
        }
        int res=0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isFinished(piles,h,mid)){
                r=mid-1;
                res=mid;
            }else{
                l=mid+1;
            }
        }
        return res;

    }
    boolean isFinished(int[] piles, int time,int rate){
        int sum=0;
        for(int pile : piles){
            sum+=pile/rate;
            sum+= pile%rate !=0? 1:0;
        }
        return sum <= time;
    }
}
