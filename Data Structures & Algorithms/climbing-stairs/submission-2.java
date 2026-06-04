class Solution {
    // looked at solution, then implemented myself
    int[] cache;
    public int climbStairs(int n) {
        // we need n+1 space so that,
        // index n == nth floor
        cache = new int[n+1];

        // we init the cache with -1,
        // because sum of all positive
        // int cannot be negative -1
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }

        return dfs(n, 0);

    }

    public int dfs(int n, int i){
        if(i==n){
            cache[i] = 1;
            return cache[i];
        }else if(i>n){
            return 0;
        }else{
            if(cache[i]!=-1){
                return cache[i];
            }else{
                cache[i] = dfs(n, i+1) + dfs(n, i+2);
                return cache[i];
            }
        }
    }
}




/*SOLUTION #1 Recursion
class Solution {
    //looked at solution, did not try myself
    public int climbStairs(int n) {
        //we start at the bottom of the stairs to i == 0
        return dfs(n, 0);
    }

    public int dfs(int n, int i){
        if (i==n){
            //we reached the top so
            //there exacty one way to reach top
            return 1;
        }else if(i>n){
            //we over-climbed
            return 0;
        }else{
            // from the 0th step,
            // we can climb 1 step or 2 step
            // so at any step i, we can climb,
            // i+1 or i+2
            return dfs(n, i+1) + dfs(n, i+2);
        }
    }
}*/
