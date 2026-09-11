class Solution {
    public int numDecodings(String s) {
        int mem[] = new int[s.length()];
        Arrays.fill(mem,-1);
        return solve(s, 0, mem);
    }
    int solve(String s, int i, int[] mem){
        if(i>=s.length()) return 1;
        if(mem[i] != -1) return mem[i];
        int oneDigit = Integer.parseInt(s.substring(i,i+1));
        int take1 = 0;
        if(oneDigit>0)
             take1 = solve(s, i + 1, mem);
        if(i+2<=s.length()){
            int twoDigit = Integer.parseInt(s.substring(i,i+2));
            if(twoDigit > 9 && twoDigit <= 26){
                return  mem[i] = solve(s, i + 2, mem) + take1;
            }
        }
        return mem[i] = take1;
        
    }
}
