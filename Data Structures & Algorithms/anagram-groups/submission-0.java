class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap();
        for(String s: strs){
            char[] s1 =s.toCharArray();
            Arrays.sort(s1);
            String s2=new String(s1);
            map.computeIfAbsent(s2,k-> new ArrayList()).add(s);
        }
        List<List<String>> res=new ArrayList();
        for(List<String> l: map.values()){
            res.add(l);
        }
        return res;
    }
}
