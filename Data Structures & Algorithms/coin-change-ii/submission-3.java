class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[coins.length][amount + 1];
        for(int m[] : mem){
            Arrays.fill(m, -1);
        }
        return solve(coins, amount, 0, mem);
    }
    int solve(int[] coins, int amount, int i, int[][] mem){
        if(amount == 0) return 1;
        if(i >= coins.length || amount < 0) return 0;
        if(mem[i][amount] != -1) return mem[i][amount];
        return mem[i][amount] = solve(coins, amount - coins[i], i, mem) + solve(coins, amount,i + 1, mem);
    }
}
