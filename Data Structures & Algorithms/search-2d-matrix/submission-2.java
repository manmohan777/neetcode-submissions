class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int cols=matrix[0].length;
        int rows=matrix.length;
        int l=0,r=(cols*rows)-1;
        while(l<=r){
            int mid=l + (r - l) / 2;
            int row=mid / cols;
            int col=mid % cols;
            if(matrix[row][col] == target)
                return true;
            if(target>matrix[row][col])
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }
}
