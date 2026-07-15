class Solution {

    Map<Integer, List<Integer>> prereqMap = new HashMap<>();

    ///Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //first we need to populate prereqMap
        for(int i=0; i< prerequisites.length; i++){
            int[] pair = prerequisites[i];

            int course  = pair[0];
            int prereq = pair[1];

            //get this course from map
            List<Integer> listOfPrereq = prereqMap.getOrDefault(course, new ArrayList<>());

            //add a new prereq for this course
            listOfPrereq.add(prereq);

            //put the list back in map.
            //if the list existed already, 
            //we would not have to put it back
            prereqMap.put(course, listOfPrereq);
        }

        //coming here means prereqMap is populated
        //now we will visit every keys
        for(int course: prereqMap.keySet()){
            boolean prereqCheck = dfs(course, new HashSet<>());

            if(!prereqCheck){
                return false;
            }
        }

        return true;
    }


    public boolean dfs(int course, Set<Integer> visited) {

        // Course is already in the current DFS path
        // Therefore, we found a cycle
        if (visited.contains(course)) {
            return false;
        }

        visited.add(course);

        List<Integer> prerequisites =
                prereqMap.getOrDefault(course, new ArrayList<>());

        for (int prereq : prerequisites) {

            if (!dfs(prereq, visited)) {
                return false;
            }
        }

        // Remove it from the current path
        visited.remove(course);

        return true;
    }

    //takes a course, and a empty set and keeps visiting children until loop found
    public boolean dfs_(int course, Set<Integer> visited){
        if(visited.contains(course)){
            return false;
        }

        visited.add(course);

        //get the prereqList for this course
        List<Integer> listOfPrereq = prereqMap.getOrDefault(course, new ArrayList<>());

        if(listOfPrereq.size()==0){
            //there is no prereq for this course
            return true;
        }else{
            //we need to check all prereq cannot have ciurcular prereq
            boolean prereqCheck = true;
            for(int prereq_: listOfPrereq){
                prereqCheck = prereqCheck && dfs(prereq_, visited);

                //mid loop check
                if(!prereqCheck){
                    return false;
                }
            }
            
            return true;
        }

    }

}
