/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
      int[]start=new int[intervals.size()];
      int[]end=new int[intervals.size()];
      int i=0;
      for(Interval interval: intervals){
        start[i]=interval.start;
        end[i] = interval.end;
        i++;
      }
      Arrays.sort(start);
      Arrays.sort(end);
      int s=0,e=0;
      int count=0;
      int res=0;
      while(s < intervals.size()){
        if(start[s]<end[e]){
            count++;
            s++;
        }else{
            count--;
            e++;
        }
        res=Math.max(res,count);
      }
      return res;
    }
}
