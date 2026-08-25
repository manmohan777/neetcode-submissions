class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastIndexs[] = new int[26];
        for(int i = 0; i< s.length(); i++){
            lastIndexs[s.charAt(i)-'a'] = i;
        }
        List<Integer> res= new ArrayList();
        for(int i=0; i< s.length(); i++){
            int lastIndex = lastIndexs[s.charAt(i)-'a'];
           
            int count = 0;
            for(int j= i; j<=lastIndex; j++){
                lastIndex = Math.max(lastIndex, lastIndexs[s.charAt(j)-'a']);
                count++;
            }
            i+=count-1;
            res.add(count);
            
        }

        return res;
    }
}
