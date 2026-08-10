class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList();
        backtrack("",res,n,0,0);
        return res;
    }
    void backtrack(String s,List<String> res,int n, int open,int close){
        if(s.length()==n*2){
             if(open==close)
                res.add(s);
            return;
        }
        backtrack(s+'(',res,n,open+1,close);
        if(open>close)
            backtrack(s+')',res,n,open,close+1);
    }
    // boolean valid(String s){
    //     int open=0;
    //     for(char c: s.toCharArray()){
    //         open+= c=='('?1:-1;
    //         if(open<0)
    //             return false;
    //     }
    //     return open==0;
    // }
}
