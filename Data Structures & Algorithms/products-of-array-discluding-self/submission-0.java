class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=0)
                left[i]= nums[i]*(left[i-1]);
            else
                left[i] = nums[i];
        }
        for(int i=n-1;i>=0;i--){
            if(i!=n-1)
                right[i]= nums[i]*(right[i+1]);
            else
                right[i] = nums[i];
        }
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                res[i]=right[i+1];
            else if(i==n-1)
                res[i]=left[i-1];
            else
                res[i]=left[i-1]*right[i+1];
        }
        return res;
    }
}  
