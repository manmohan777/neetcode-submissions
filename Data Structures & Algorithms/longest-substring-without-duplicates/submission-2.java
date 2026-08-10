class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        Set<Character> set= new HashSet();
        int l=0;
        int r=l+1;
        int res=0;
        set.add(s.charAt(l));
        while(r<s.length()){    
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res=Math.max(res,(r-l)+1);
            r++;
        }
        return res;
    }
}
