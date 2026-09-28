class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] res =new int[2];
        for(int i = 0; i< n; i++){
            int[] int1 = find(s, i, i);
            if(int1[1]-int1[0]>res[1]-res[0]){
                res = int1;
            }
            int[] int2 = find(s, i, i+1);
            if(int2[1]-int2[0]>res[1]-res[0]){
                res = int2;
            }
        }
        return s.substring(res[0],res[1]+1);
    }

    int[] find(String s, int i, int j){
        int[] res = new int[2];
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            res[0]=i;
            res[1]=j;
            i--;
            j++;
        }
        return res;
    }
}
