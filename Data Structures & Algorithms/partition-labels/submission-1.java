class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastIndexs[] = new int[26];
        for(int i = 0; i< s.length(); i++){
            lastIndexs[s.charAt(i)-'a'] = i;
        }
        List<Integer> res= new ArrayList();
        int size=0,lastIndex = 0;
        for(int i=0; i< s.length(); i++){
            size++;
            lastIndex = Math.max(lastIndex,lastIndexs[s.charAt(i)-'a']);
           
            if(i==lastIndex){
                res.add(size);
                size=0;
            }
            
        }

        return res;
    }
}
