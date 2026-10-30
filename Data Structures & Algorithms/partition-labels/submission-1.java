//planned by me but used chatgpt for autofill
//we first count the freq index of each char
//then we get a range for each char
//then we merge the ranges
//ex: xyxxyzbzbbisl
    //x -> 0,2,3
    //y -> 1,4
    //z -> 5,7
    //b -> 6,8,9
    //i -> 10
    //s -> 11
    //l -> 12
//then i get ranges [0,3][1,4][5,7][6,9][10],[11],[12] and merge them

class Solution {
    public List<Integer> partitionLabels(String s) {

        //first, compute the indexes of each char
        List<Character> uniqueChars = new ArrayList<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //put in list
            if(!uniqueChars.contains(c)){
                uniqueChars.add(c);
            }

            //put in map
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }    

        //second, create a 2d interval for the 
        int[][] intervals = new int[uniqueChars.size()][2];

        for (int i = 0; i < uniqueChars.size(); i++) {
            char c = uniqueChars.get(i);

            List<Integer> indexes = map.get(c);

            intervals[i][0] = indexes.get(0); // start index
            intervals[i][1] = indexes.get(indexes.size() - 1); // end index
        }

        //here: merge overlapping intervals
        int[][] mergedIntervals = merge(intervals);

        List<Integer> result = new ArrayList<>();

        for (int[] interval : mergedIntervals) {
            result.add(interval[1] - interval[0] + 1);
        }

        return result;
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if(intervals.length==0){
            int[][] res = new int[1][2];
            return res;
        }

        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        int i=1;
        while(i<intervals.length && stack.size()>=1){
            int[] lastItem = stack.pop();
            int[] currItem = intervals[i];

            //check for merge
            // Intervals are overlapping if they have common point hence using >=
            if(lastItem[1] >= currItem[0]){
                //needs merging
                lastItem[0] = Math.min(lastItem[0], currItem[0]); 
                lastItem[1] = Math.max(lastItem[1], currItem[1]); 
                stack.push(lastItem);
            }else{
                //no merging needed
                stack.push(lastItem);
                stack.push(currItem);
            }
            i++;
        }

        int[][] array2D = stack.toArray(new int[stack.size()][]);

        return array2D;


    }
}
