class Solution {
    Map<Integer, Integer> memo;
    public int numDecodings(String s) {
        memo = new HashMap<>();
        return solve(s,0);
    }
    int solve(String s,int i){
        if(i>= s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(memo.containsKey(i)) return memo.get(i);
        int takeOne = solve(s, i+1);
        int takeTwo = 0;
        if(i+1<s.length()){
            if(Integer.parseInt(s.substring(i,i+2)) <= 26){
                takeTwo = solve(s,i+2);
            }
        }
        int res = takeOne+takeTwo;
        memo.put(i,res);
        return res;
    }
}
