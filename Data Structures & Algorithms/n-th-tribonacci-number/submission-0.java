class Solution {

    int[] memo;

    public int tribonacci(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    public int dfs(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = dfs(n - 1) + dfs(n - 2) + dfs(n - 3);

        return memo[n];
    }
}




/*
//Fibonacci
class Solution {

    int[] memo;

    public int fib(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    public int dfs(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = dfs(n - 1) + dfs(n - 2);

        return memo[n];
    }
}


*/