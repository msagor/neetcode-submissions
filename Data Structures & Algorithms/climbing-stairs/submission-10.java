
//implementation #3
//we modified last implementation,
//this is a naive tree based solution with bottom up approach with memoization.
//note we check the map for currIteration
class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int n = -1;

    public int climbStairs(int n) {
        this.n = n;
        return dfs(0); //we start from the bottom
    }

    public int dfs(int currIteration) {


        //reached the top
        if(currIteration==n){
            return 1;
        }

        //overflow
        if(currIteration>n){
            return 0;
        }
        
        //check current iteration in the map
        if (map.containsKey(currIteration)) { 
            return map.get(currIteration); 
        }

        //keep branching 1 step
        int count1 = dfs(currIteration+1);

        //keep branching 2 step
        int count2 = dfs(currIteration+2);

        int totalCount = count1 + count2;

        map.put(currIteration, totalCount);

        return totalCount;
    }

}

/*
implementation #2
//we modified last implementation,
//this is a naive tree based solution with bottom up approach still.
//and now we return 1 every time we reach n.
//we need to add memoization to this now to avoid repeated work.
class Solution {
    int n = -1;
    public int climbStairs(int n) {
        this.n = n;
        return dfs(0); //we start from the bottom
    }

    public int dfs(int currIteration) {


        //reached the top
        if(currIteration==n){
            return 1;
        }

        //overflow
        if(currIteration>n){
            return 0;
        }
        
        //keep branching 2 step
        int count2 = dfs(currIteration+2);

        //keep branching 1 step
        int count1 = dfs(currIteration+1);

        int totalCount = count2 + count1;

        return totalCount;
    }

}

*/


/*
implementation #1
//this is a naive tree based solution with bottom up approach (start from n=0).
//we need to modify this so that it returns 1 every time we reach n
class Solution {

    int count = 0;
    int n = -1;

    public int climbStairs(int n) {
        this.n = n;
        dfs(0);
        return count;
    }

    public void dfs(int currIteration) {


        //reached the top
        if(currIteration==n){
            count++;
            return;
        }

        //overflow
        if(currIteration>n){
            return;
        }
        
        //keep branching 2 step
        dfs(currIteration+2);

        //keep branching 1 step
        dfs(currIteration+1);
    }

}

*/