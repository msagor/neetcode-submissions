
//watched video then implemented myself, then chatgpt fixed multiple bugs
class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        //Assuming cars going from left to right, 
        //so if two cars are going the same way, 
        //they will only meet (become a fleet)
        //if the front car is going slower than car on the behind.
        //we are given the speed v and the position s,
        //so we need to compute time t to reach the destination
        //then we compare time t for each of the car.
        //if car A behind car B, and t of car A is smaller than t of car B,
        //that means A will catch up to B at some point, so they become one fleet.
        //at this point, we eliminate A as if it didnt exist.

        //first, we put every s,v in a 2d array
        int[][] s_v = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            int[] item = new int[]{
                position[i],
                speed[i]
            };

            s_v[i] = item;
        }

        //second, sort the array in descending order by position
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0], a[0]);
            }
        };

        //Arrays.sort(s_v, (a,b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(s_v, cmp);

        //third, we compute time t for each element and put them in stack
        //when size reaches two, we compare their times
        //t = (target - position)/speed
        //time t is Double
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < s_v.length; i++) {
            int[] item = s_v[i];

            double item_t = (double) (target - item[0]) / item[1];

            stack.push(item_t);

            if (stack.size() >= 2) {

                //we need to compare these times
                //suppose car A follows car B
                double car_A_t = stack.pop();
                double car_B_t = stack.pop();

                //compare their t
                if (car_A_t <= car_B_t) {
                    //car A will catch up to car B so they become a fleet
                    //in other words, as if car A never existed.
                    //so we put back car B value
                    stack.push(car_B_t);
                } else {
                    //car A and car B will never become a fleet
                    stack.push(car_B_t);
                    stack.push(car_A_t);
                }
            }
        }

        return stack.size();
    }
}