//used backtracking only, no memoization
public class Solution {

    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<>(wordDict);

        List<String> path = new ArrayList<>();

        dfs(s, wordSet, 0, path);

        return result;
    }

    private void dfs(String s, HashSet<String> wordSet, int i, List<String> path) {

        // Reached the end successfully
        if (i == s.length()) {
            String res = "";
            for(int pi=0; pi<path.size(); pi++){
                String p = path.get(pi);
                res = res + p;

                if(pi!=path.size()-1){
                    res = res + " ";
                }
            }

            result.add(res);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            
            if (wordSet.contains(s.substring(i, j + 1))) {                
                
                //add to path
                path.add(s.substring(i, j + 1));
                
                dfs(s, wordSet, j + 1, path);

                path.removeLast();
            }
        }

    }
}