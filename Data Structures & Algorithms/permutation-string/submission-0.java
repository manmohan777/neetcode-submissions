class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int mp1[] = new int[26];
        int mp2[] = new int[26];
        int i=0,j=0;
        while (j < s1.length()) {
            mp1[s1.charAt(j) - 'a']++;
            mp2[s2.charAt(j) - 'a']++;
            j++;
        }
        while(j<s2.length()){
            if(isEqual(mp1,mp2))
                return true;
            mp2[s2.charAt(i)-'a']--;
            i++;
            mp2[s2.charAt(j)-'a']++;
            j++;
        }
        return isEqual(mp1,mp2);
    }
    boolean isEqual(int[] a,int[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
