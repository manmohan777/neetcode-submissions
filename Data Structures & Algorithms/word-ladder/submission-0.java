class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> adj = new HashMap();
        wordList.add(beginWord);
        for(String word: wordList){
            fillNeighbours(word,wordList,adj);
        }
        Set<String> visited = new HashSet();
        return bfs(adj,visited,beginWord,endWord);
    }

    int bfs(Map<String,List<String>> adj, Set<String> visited, String beginWord, String endWord){
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        visited.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                String u = q.poll();
                if(u.equals(endWord)) return steps;
                for(String v: adj.getOrDefault(u,new ArrayList<>())){
                    if(!visited.contains(v)){
                        q.add(v);
                        visited.add(v);
                    }
                }
                
                size--;
            }
            steps++;
        }
        return 0;
    }

    void fillNeighbours(String word,List<String> wordList,Map<String,List<String>> adj){
        for(int i = 0; i< wordList.size(); i++){
            String current = wordList.get(i);
            if(!current.equals(word)){
                int diff = 0;
                for(int j = 0; j< word.length(); j++){
                    if(word.charAt(j) != current.charAt(j)){
                        diff++;
                    }
                    if(diff>=2) break;
                }
                if(diff == 1){
                    adj.computeIfAbsent(word,key-> new ArrayList<>()).add(current);

                }
            }
        }
    }
}
