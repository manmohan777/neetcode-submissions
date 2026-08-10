class Solution {
    public boolean isPalindrome(String s) {
        String cl = s.replaceAll("[^a-zA-Z0-9]", "");
        String clean=cl.toLowerCase();
        int i=0,j=clean.length()-1;
        while(i<j){
            if(clean.charAt(i)!=clean.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
