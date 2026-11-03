class Solution {

    Map<Integer, List<Integer>> prereq = new HashMap<>();

    Set<Integer> coursesWithoutDep = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //first, populate the prereq map aka our adjacency list
        for(int[] pre: prerequisites) {
            prereq.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        //second, go over all courses and run dfs
        for(int i=0; i<numCourses; i++){
            boolean ret = dfs(i, new ArrayList<>());

            if(!ret){
                return false;
            }
        }

        //default return 
        return true;
    }

    public boolean dfs(int course, List<Integer> visited){
        
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
        visited.removeLast();



        //coming here means this course has passed dependency check
        coursesWithoutDep.add(course);

        //default return
        return true;
    }
}