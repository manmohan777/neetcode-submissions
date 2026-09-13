class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        memo = new int[nums.length][nums.length];
        for(int mem[]: memo)
            Arrays.fill(mem, -1);
        return solve(0,nums.length-1,nums);
    }
    int solve(int l,int r, int[] nums){
        if(l>r) return 0;
        if(l<0) return 1;
        if(r>= nums.length) return 1;
        if(memo[l][r] != -1) return memo[l][r];
        int res = Integer.MIN_VALUE;
        for(int i =l;i<=r; i++){
            int current;
            if(l==0&&r==nums.length-1)
                current = nums[i];
            else if(l==0)
                current = nums[i]*nums[r+1];
            else if(r==nums.length-1)
                current = nums[i]*nums[l-1];
            else
                current = nums[l-1] * nums[i] * nums[r+1];
            int left = solve(l,i-1,nums);
            int right = solve(i+1,r,nums);
            res = Math.max(left+right+current,res);
        }
        return memo[l][r] = res;
    }
}
