class Solution {
    public List<Integer> partitionLabels(String s) {
        int []last = new int[26];
        Arrays.fill(last,-1);
        for(int i=s.length()-1;i>=0;i--){
            int current = s.charAt(i)-'a';
            if(last[current]==-1){
                last[current] = i;
            }
        }
        List<Integer> res= new ArrayList();
        for(int i = 0; i< s.length(); i++){
            int current = s.charAt(i)-'a';
            int lastIndex = last[current];
            for(int j=i;j<=lastIndex;j++){
                lastIndex = Math.max(lastIndex,last[s.charAt(j)-'a']);
            }
            res.add(lastIndex- i + 1);
            i=lastIndex;
        }
        return res;
    }
}
