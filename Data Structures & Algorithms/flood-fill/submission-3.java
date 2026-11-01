
//sample BFS 
//implemented myself but i think solution version is easier to type.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //base case check
        if (image[sr][sc] == color) {
            return image;
        }

        //keep a copy of the orig color
        int originalColor = image[sr][sc];

        //create a queue
        Queue<int[]> queue = new LinkedList<>();

        //mark the first element as visited before putting in queue.
        //we add them so that we can check oin their neighbors.
        //also, item added to the queue only after they are colored.
        image[sr][sc] = color;

        //put these indexes in the q for the start
        queue.offer(new int[]{sr, sc});

        while(!queue.isEmpty()){
            //poll
            int[] item = queue.poll();

            //get current r and c
            int r = item[0];
            int c = item[1];

            //check up
            int r1 = r-1;
            int c1 = c;
            if(r1>=0 && image[r1][c1]==originalColor){
                //up neighbor is valid
                //we color the neighbor and add it to the queue
                image[r1][c1]=color;
                queue.offer(new int[]{r1, c1});
            }

            //check down
            int r2 = r+1;
            int c2 = c;
            if(r2<=image.length-1 && image[r2][c2]==originalColor){
                //down neighbor is valid
                //we color the neighbor and add it to the queue
                image[r2][c2]=color;
                queue.offer(new int[]{r2, c2});
            }

            //check left
            int r3 = r;
            int c3 = c-1;
            if(c3>=0 && image[r3][c3]==originalColor){
                //left neighbor is valid
                //we color the neighbor and add it to the queue
                image[r3][c3]=color;
                queue.offer(new int[]{r3, c3});
            }

            //check right
            int r4 = r;
            int c4 = c+1;
            if(c4<=image[0].length-1 && image[r4][c4]==originalColor){
                //right neighbor is valid
                //we color the neighbor and add it to the queue
                image[r4][c4]=color;
                queue.offer(new int[]{r4, c4});
            }
        }

        return image;
        
    }
}