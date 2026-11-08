//i implemented the backtracking, chatgpt added memoization to it
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<>(wordDict);

        // memo[i] = whether dfs starting at index i can successfully break the string
        Boolean[] memo = new Boolean[s.length()];

        dfs(s, wordSet, 0, memo);

        return memo[0];
    }

    private boolean dfs(String s, HashSet<String> wordSet, int i, Boolean[] memo) {

        // Reached the end successfully
        if (i == s.length()) {
            return true;
        }

        // Already computed this state
        if (memo[i] != null) {
            return memo[i];
        }

        for (int j = i; j < s.length(); j++) {

            if (wordSet.contains(s.substring(i, j + 1))) {

                if (dfs(s, wordSet, j + 1, memo)) {
                    return memo[i] = true;
                }
            }
        }

        return memo[i] = false;
    }
}