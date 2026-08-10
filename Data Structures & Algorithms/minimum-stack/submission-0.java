class MinStack {
    class Node{
        public int val;
        public int min;
        Node(int val,int min){
            this.val=val;
            this.min=min;
        }
    }
    Stack<Node> st;

    public MinStack() {
        st=new Stack();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Node(val,val));
        }else{
            st.push(new Node(val,Math.min(st.peek().min,val)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
