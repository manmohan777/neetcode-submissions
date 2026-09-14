class Solution {
    Map<String,Boolean> memo;
    public boolean isMatch(String s, String p) {
        memo = new HashMap<>();
        return solve( s, p,0,0);
    }

    boolean solve(String s, String p, int i, int j){
        if(j==p.length()) return i==s.length();
        boolean match = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));
        String key = i+" " + j;
        if(memo.containsKey(key)) return memo.get(key);
        if(j+1 < p.length() && p.charAt(j+1)=='*'){
            boolean res = solve(s, p, i, j+2) || (match && solve(s, p, i+1, j ));
            memo.put(key,res);
            return res;
        }
        if(match){
            boolean res = solve(s, p, i+1, j+1);
            memo.put(key,res);
            return res;
        }
        memo.put(key,false);
        return false;
    }
}
