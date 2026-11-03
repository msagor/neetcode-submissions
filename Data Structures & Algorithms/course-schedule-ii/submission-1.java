class Solution {

    Map<Integer, List<Integer>> prereq = new HashMap<>();

    Set<Integer> coursesWithoutDep = new HashSet<>();

    List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
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
                return new int[]{};
            }
        }

        //default return 
        return result.stream().mapToInt(Integer::intValue).toArray();
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

        result.add(course);

        //default return
        return true;
    }
}
