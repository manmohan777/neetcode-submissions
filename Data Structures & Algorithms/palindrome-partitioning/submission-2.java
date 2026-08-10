class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList();
        getPalindrome(s,0,new ArrayList(),res);
        return res;
    }
    void getPalindrome(String s,int start,List<String> sublist,List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList(sublist));
            return;
        }
        for(int end=start+1;end<=s.length();end++){
            String sub=s.substring(start,end);
            if(isPalindrome(sub)){
                sublist.add(sub);
                getPalindrome(s,end,sublist,res);
                sublist.remove(sublist.size()-1);
            }
        }
       
    }
    boolean isPalindrome(String s){
        char[] s1=s.toCharArray();
        int i=0,j=s1.length-1;
        while(i<j){
            if(s1[i]!=s1[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

}
