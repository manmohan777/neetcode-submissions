class Solution {
    public boolean isPalindrome(String s) {
        String clean=s.toLowerCase();
        int i=0,j=clean.length()-1;
        while(i<j){
            while (i < j && !Character.isLetterOrDigit(clean.charAt(i))) {
                i++;
            }
            while (j > i && !Character.isLetterOrDigit(clean.charAt(j))) {
                j--;
            }
            if(clean.charAt(i)!=clean.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
