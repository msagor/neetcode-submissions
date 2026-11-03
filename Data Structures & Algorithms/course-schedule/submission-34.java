//see commented code below for nother implementation of mine
class Solution {

    Map<Integer, List<Integer>> prereqMap = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //first create the adjacency list
        //if list doesnt exist, create a list and add value in the list,
        //if the list exists, appenbd value in the list
        for(int[] pre: prerequisites) {
            prereqMap.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
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
    //basically its backtracking
    public boolean dfs(int course, Set<Integer> visited) {

        // Course is already in the current DFS path
        // Therefore, we found a cycle
        if(visited.contains(course)) {
            return false;
        }

        //add this course to the current DFS path
        visited.add(course);

        //get all prerequisites for this course
        List<Integer> prerequisites = prereqMap.getOrDefault(course, new ArrayList<>());

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

/*

//working implementation done by me
//diff with above impl is - we use a hashset coursesWithoutDep here
class Solution {

    Map<Integer, List<Integer>> prereq = new HashMap<>();

    Set<Integer> coursesWithoutDep = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //first, populate the prereq map aka our adjacency list
        for(int i=0; i<prerequisites.length; i++){
            int[] pre = prerequisites[i];

            if(prereq.containsKey(pre[0])){
                //get list out
                List<Integer> allprereqs = prereq.get(pre[0]);

                //add in list
                allprereqs.add(pre[1]);

                //put list back
                prereq.put(pre[0], allprereqs);
            }else{
                //create a new list in the map
                List<Integer> allprereqs = new ArrayList<>();

                //add in list
                allprereqs.add(pre[1]);

                //put list back
                prereq.put(pre[0], allprereqs);
            }
        }

        //second, go over all courses and run dfs
        for(int i=0; i<numCourses; i++){
            boolean ret = dfs(i, new HashSet<>());

            if(!ret){
                return false;
            }
        }

        //default return 
        return true;
    }

    public boolean dfs(int course, Set<Integer> visited){
        
        //check if this course already dep checked
        if(coursesWithoutDep.contains(course)){
            return true;
        }
        
        //if course in visited already return false
        if(visited.contains(course)){
            return false;
        }

        //mark this course as visited
        visited.add(course);

        //get all prereq of this course
        if(prereq.containsKey(course)){
            
            List<Integer> list = prereq.get(course);

            for(int pre: list){
                boolean r = dfs(pre, visited);

                if(!r){
                    return false;
                }
            }
        }

        //visit done to remove this course from visit set
        visited.remove(course);

        //coming here means this course has passed dependency check
        coursesWithoutDep.add(course);

        //default return
        return true;
    }
}
*/