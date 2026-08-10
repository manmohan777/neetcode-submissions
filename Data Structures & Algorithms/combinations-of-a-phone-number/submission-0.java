class Solution {
     private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList();
        List<String> res=new ArrayList();
        dfs(0,digits,res,"");
        return res;
    }
    void dfs(int i,String digits, List<String> res,String s){
        if(i==digits.length()){
            res.add(s);
            return;
        }
        for(char c: digitToChar[digits.charAt(i)-'0'].toCharArray()){
            dfs(i+1,digits,res,s+c);
        }
    }
}
