class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() &&
                w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j),
                                     indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry: indegree.entrySet()){
            if(entry.getValue()==0)
                q.offer(entry.getKey());
        }
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            char u = q.poll();
            res.append(u);
            for(char v: adj.getOrDefault(u,new HashSet<>()))
            {
                indegree.put(v,indegree.get(v)-1);
                if(indegree.get(v)==0){
                    q.add(v);
                }
            }
        }
        if(res.length() !=indegree.size())
            return "";
        return res.toString();
    }
}
