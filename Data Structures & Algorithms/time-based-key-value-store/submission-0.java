class TimeMap {
    class Node {
        String value;
        int time;
        Node(String value,int time){
            this.value = value;
            this.time = time;
        }
    }
    HashMap<String,List<Node>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k-> new ArrayList<Node>()).add(new Node(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Node> res=map.get(key);
        int l=0, r = res.size()-1;
        String val = "";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(res.get(mid).time<=timestamp){
                l=mid+1;
                val= res.get(mid).value;
            }else{
                r=mid-1;
            }
        }
        return val;
    }
}
