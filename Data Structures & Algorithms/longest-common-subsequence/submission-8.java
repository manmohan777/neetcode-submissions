class Solution {
    HashMap<String,Integer> memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new HashMap<>();
        return solve(text1, text2, 0, 0);
    }

    int solve(String text1, String text2, int i, int j){
        if(i>= text1.length() || j>= text2.length()) return 0;
        String key= i+" "+j;
        if(memo.containsKey(key)) return memo.get(key);
        int res = Math.max(solve(text1,text2,i+1,j), solve(text1,text2,i,j+1));
        if(text1.charAt(i) == text2.charAt(j)){
            res = Math.max(1+ solve(text1, text2, i+1, j+1),res);
        }
        memo.put(key,res);
        return res;
        
    }

}
