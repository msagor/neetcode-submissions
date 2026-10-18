//implemented the dfs without memoization so some test cases were not passing.
//chatgpt helped me add memoization 

//note that the memoization has three possible states - 
    //null → state not computed yet.
    //true → state computed and valid.
    //false → state computed and invalid.
//hence we use Boolean (null, true, false) as opposed to boolean (true, false).

class Solution {

    Boolean[][][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][n][n];
        return dfs(s, 0, 0, 0);
    }

    public boolean dfs(String s, int idx, int open, int close) {

        // Index reached end
        if (idx == s.length()) {
            return open == close;
        }

        // Prune invalid states
        if (close > open) {
            return false;
        }

        // Check memoization
        if (memo[idx][open][close] != null) {
            return memo[idx][open][close];
        }

        char c = s.charAt(idx);
        boolean res;
        switch (c) {
            case '(':
                res = dfs(s, idx + 1, open + 1, close);
                memo[idx][open][close] = res;
                return res;
            case ')':
                res = dfs(s, idx + 1, open, close + 1);
                memo[idx][open][close] = res;
                return res;

            case '*':
                res = 
                    dfs(s, idx + 1, open, close) ||
                    dfs(s, idx + 1, open + 1, close) ||
                    dfs(s, idx + 1, open, close + 1);
                memo[idx][open][close] = res;
                return res;
        }

        return true; //can be false as well
    }
}
