class Solution {
    class Node{
        int val;
        int index;
        Node(int val, int index){
            this.val= val;
            this.index=index;
        }
    }
    public int[] dailyTemperatures(int[] temp) {
        Stack<Node> st=new Stack();
        int res[] = new int[temp.length];
        for(int i=temp.length-1;i>=0;i--){
            int t=temp[i];
            while(!st.isEmpty()&& st.peek().val<=t){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=0;
            }else{
                res[i]=st.peek().index-i;
            }
            st.push(new Node(t,i));
        }
        return res;
    }
}
