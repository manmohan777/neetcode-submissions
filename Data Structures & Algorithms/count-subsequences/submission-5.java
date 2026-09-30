class Solution {
    Map<String, Integer> memo;
    public int numDistinct(String s, String t) {
        memo = new HashMap<>();
        return solve(s,t,0,0);
    }
    int solve(String s, String t,int i, int j){
        if(i>=s.length()) return j >= t.length()? 1:0;
        if(j >= t.length()) return 1;
        String key = i+" "+j;
        if(memo.containsKey(key)) return memo.get(key);
        int res = solve(s, t, i+1, j);
        if(s.charAt(i)== t.charAt(j)){
            res+= solve(s, t, i+1, j+1);
        }
        memo.put(key, res);
        return res;
    }
}
