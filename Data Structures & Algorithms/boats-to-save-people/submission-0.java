class Solution {

    //solution from chatgpt
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            
            if (people[left] + people[right] <= limit) {

                //if p1 and p2 can ride together
                //so go to next p1
                left++;

                //also go to next p2
                right--;

                //one boat needed for p1 and p2
                boats++;
            }else{
                //if p1 and p2 cannot ride together

                //since the array is sorted,
                //this p2 person must ride by himself
                //so we go to next p2
                right--;

                //one boat needed for p2
                boats++;
            }
        }

        return boats;
    }
}