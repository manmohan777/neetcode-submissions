class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int mp1[] = new int[26];
        int i=0,j=0;
        while (j < s1.length()) {
            mp1[s1.charAt(j) - 'a']++;
            mp1[s2.charAt(j) - 'a']--;
            j++;
        }
        while(j<s2.length()){
            if(isEqual(mp1))
                return true;
            mp1[s2.charAt(i)-'a']++;
            i++;
            mp1[s2.charAt(j)-'a']--;
            j++;
        }
        return isEqual(mp1);
    }
    boolean isEqual(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                return false;
            }
        }
        return true;
    }
}
