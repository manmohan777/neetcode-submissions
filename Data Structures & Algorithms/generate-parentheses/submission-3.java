class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList();
        backtrack(res,n*2,new StringBuilder(),0,0);
        return res;
    }

    void backtrack(List<String> res, int n, StringBuilder sub, int left, int right){
        if(sub.length() >= n){
            if(left==right)
                res.add(sub.toString());
            return;
        }

        sub.append('(');
        backtrack(res,n,sub,left+1,right);
        sub.deleteCharAt(sub.length()-1);
        if(right<left){
            sub.append(')');
            backtrack(res,n,sub,left,right+1);
             sub.deleteCharAt(sub.length()-1);
        }
    }
    
}
