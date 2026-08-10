class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap();
        for(String s: strs){
            int[] count=new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            map.computeIfAbsent(Arrays.toString(count),k-> new ArrayList()).add(s);
        }
        List<List<String>> res=new ArrayList();
        for(List<String> l: map.values()){
            res.add(l);
        }
        return res;
    }
}
