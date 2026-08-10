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
        for(int i=0;i<temp.length;i++){
            int t=temp[i];
            while(!st.isEmpty()&& st.peek().val<t){
                Node n=st.pop();
                res[n.index] = i-n.index;
            }
            st.push(new Node(t,i));
        }
        return res;
    }
}
