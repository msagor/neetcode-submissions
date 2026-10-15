
//my implementation but chatgpt fixed most of it

//you need to use backtracking with bucket to solve this problem,
//not two pointer based greedy approach - see below implementation.


//note regarding visited array:
//note that since we have to pic arbitrary sticks, we cannot keep track of which visited we pciekd last.
//some array problems we go from left to right only, in those case keeping track of last visit index makes sense.
//in this case, visited is being used arbitrarily, so we must always go from 0 to end in every iteration.

//note regarding bucket:
//lets list all the cases bucket can have - 
    //when bucket  end up having equal length sticks, return true
    //bucket index overflows, return false
    //any bucket has more than expected, return false
    //if this bucket full, increment bucket index

class Solution {

    public boolean makesquare(int[] matchsticks) {

        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        Arrays.sort(matchsticks);

        // Reverse to descending order
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }

        int total = 0;

        for (int m : matchsticks) {
            total += m;
        }

        // Check if total is divisible by 4
        if (total % 4 != 0) {
            return false;
        }

        // Get the theoretical length of one side
        int side = total / 4;

        // Check if the largest stick is longer than one side
        if (matchsticks[0] > side) {
            return false;
        }

        // Use backtracking
        boolean[] visited = new boolean[matchsticks.length];

        // FIX: Buckets must start at zero, not at the target side
        int[] bucket = new int[]{0, 0, 0, 0};

        return backtrack(matchsticks, bucket, 0, side, visited);
    }

    public boolean backtrack(
        int[] matchsticks,
        int[] bucket,
        int bucketIndex,
        int maxBucketSize,
        boolean[] visited
    ) {

        //all bucket check
        if (bucket[0] == maxBucketSize &&
            bucket[1] == maxBucketSize &&
            bucket[2] == maxBucketSize &&
            bucket[3] == maxBucketSize) {
            return true;
        }

        //bucket index check
        if (bucketIndex >= bucket.length) {
            return false;
        }

        //check if bucket overflows already
        if (bucket[bucketIndex]> maxBucketSize) {
            return false;
        }

        //if this bucket full increment bucket
        if (bucket[bucketIndex] == maxBucketSize) {
            bucketIndex++;
        }

        for (int i = 0; i < matchsticks.length; i++) {

            if (visited[i]) {
                continue;
            }else{
                visited[i] = true;
                bucket[bucketIndex] = bucket[bucketIndex] + matchsticks[i];

                boolean bt = backtrack(matchsticks, bucket, bucketIndex, maxBucketSize, visited);

                if (bt) {
                    return true;
                }

                visited[i] = false;
                bucket[bucketIndex] -= matchsticks[i];
            }
        }

        return false;
    }
}


/*
//two pointer based greedy solution that works for some test cases
//implemented entirely by myself
class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);

        int total=0;
        for(int m:matchsticks){
            total+=m;
        }

        //check if total divisible by 4
        if(total%4!=0){
            return false;
        }

        //get the theoretical length of one side
        int side = total/4;

        //check if largest stick is longer than side
        if(matchsticks[matchsticks.length-1]>side){
            return false;
        }

        //coming here means there should be a valid solution
        int l = 0;
        int r = matchsticks.length-1;
        int sideCount = 0; //reaches to 4

        while(l<r){

            //get the largest possible stick
            int oneSide = matchsticks[r];

            while(oneSide<side){
                oneSide+= matchsticks[l];
                l++;
            }

            //check if oneSide overfloew
            if(oneSide>side){
                return false;
            }

            r--;
            sideCount++;
            
            
        }

        if(sideCount==4){
                return true;
        }

        return false;
    }
}

*/