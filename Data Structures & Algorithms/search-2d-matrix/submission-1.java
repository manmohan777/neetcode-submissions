class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int cols=matrix[0].length;
        int rows=matrix.length;
        int top=0,bottom=rows-1;
        while(top<=bottom){
            int mid= top+(bottom-top)/2;
            if(target > matrix[mid][cols-1]){
                top=mid+1;
            }else if(target<matrix[mid][0]){
                bottom=mid-1;
            }else{
                break;
            }
        }
        if(top>bottom)
            return false;
        int row=top+(bottom-top)/2;
        int l=0,r=cols-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(matrix[row][mid]==target)
                return true;
            if(target>matrix[row][mid])
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }
}
