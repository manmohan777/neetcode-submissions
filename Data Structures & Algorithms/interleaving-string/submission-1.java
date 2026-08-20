class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {        Map<String,Boolean> memo = new HashMap();
        return dfs(0,0,0,s1,s2,s3,memo);
}
boolean dfs(int i, int j, int k, String s1, String s2, String s3, Map<String,Boolean> memo){
    if(k==s3.length()){
        return i==s1.length() && j == s2.length();
    }
    String key=i+"-"+j;
    if(memo.containsKey(key)) return memo.get(key);
    if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){ //take from s1
        if(dfs(i+1,j,k+1,s1,s2,s3,memo)){
            memo.put(key,true);
            return true;
        }
    }
    if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){ //take from s2
        if(dfs(i,j+1,k+1,s1,s2,s3,memo)){
            memo.put(key,true);
            return true;
        }
    }
    memo.put(key,false);
    return false;
}

}
