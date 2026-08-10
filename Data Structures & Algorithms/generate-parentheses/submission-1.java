class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList();
        backtrack(res,n*2,"",0,0);
        return res;
    }
    void backtrack(List<String> res,int n,String s,int start,int end){
        if(n==0){
            if(start==end)
                res.add(s);
            return;
        }
        backtrack(res,n-1,s+"(",start+1,end);
        if(end<start)
            backtrack(res,n-1,s+")",start,end+1);
        
    }
}
