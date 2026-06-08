class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j = heights.length-1;

        int result = 0;

        while(i<j){
            int width = j-i;
            int bar1 = heights[i];
            int bar2 = heights[j];

            int smaller_bar = Math.min(bar1, bar2);

            int area_res = width * smaller_bar;

            if(result<area_res){
                result = area_res; //new maximum

            }

            //need to move one bar,
            //it could be bar i or bar j.
            //we need to move the smaller bar.
            //when bar1 moves, we do i++
            //when bar2 moves, we do j--;
            if(bar1<bar2){
                i++;
            }else{
                j--;
            }

        }

        return result;
    }
}
