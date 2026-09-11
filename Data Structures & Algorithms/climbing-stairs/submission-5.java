class Solution {
    public int climbStairs(int n) {
        int mem[] = new int[n];
        Arrays.fill(mem, -1);
        return solve(n, 0, mem);
    }
    int solve(int n, int i, int[] mem){
        if(i==n) return 1;
        if(i > n) return 0;
        if(mem[i] !=-1) return mem[i];
        return mem[i] = solve(n, i+1, mem) + solve(n, i+2, mem);
    }
}
