class Solution {
    class Node{
        int speed;
        int position;
        Node(int speed,int position){
            this.speed=speed;
            this.position=position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Node> list = new ArrayList();
        for(int i=0;i<position.length;i++){
            list.add(new Node(speed[i],position[i]));
        }
        list.sort((a,b)->b.position-a.position);
        Stack<Double> st=new Stack();
        for(Node node : list){
            st.push((double) (target-node.position)/node.speed);
            if(st.size()>=2 &&
                st.peek()<=st.get(st.size()-2))
            {
                    st.pop();
                
            }
        }
        return st.size();
    }
}

