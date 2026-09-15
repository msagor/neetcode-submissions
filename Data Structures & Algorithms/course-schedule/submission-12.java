class Solution {

    Map<Integer, List<Integer>> prereqMap = new HashMap<>();

    ///Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //first we need to populate prereqMap
        for(int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];

            int course = pair[0];
            int prereq = pair[1];

            //get this course from map
            List<Integer> listOfPrereq =
                    prereqMap.getOrDefault(course, new ArrayList<>());

            //add a new prereq for this course
            listOfPrereq.add(prereq);

            //put the list back in map.
            //if the list existed already,
            //we would not have to put it back
            prereqMap.put(course, listOfPrereq);
        }

        //coming here means prereqMap is populated
        //now we will visit every course
        for(int course = 0; course < numCourses; course++) {

            boolean prereqCheck = dfs(course, new HashSet<>());

            if(!prereqCheck) {
                return false;
            }
        }

        return true;
    }

    //dfs from chatgpt, that works
    public boolean dfs(int course, Set<Integer> visited) {

        // Course is already in the current DFS path
        // Therefore, we found a cycle
        if(visited.contains(course)) {
            return false;
        }

        //add this course to the current DFS path
        visited.add(course);

        //get all prerequisites for this course
        List<Integer> prerequisites =
                prereqMap.getOrDefault(course, new ArrayList<>());

        //visit all prerequisites
        for(int prereq : prerequisites) {

            if(!dfs(prereq, visited)) {
                return false;
            }
        }

        // IMPORTANT:
        // We are done exploring this path.
        // Remove the course so it can be visited through another path.
        visited.remove(course);

        //coming here means we completely checked this course
        //and this course does not lead to a cycle.
        //so clear its prerequisite list so we do not
        //have to check the same path again later.
        prereqMap.put(course, new ArrayList<>());

        return true;
    }
}