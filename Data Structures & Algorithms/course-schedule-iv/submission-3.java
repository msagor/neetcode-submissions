
class Solution {

    Map<Integer, List<Integer>> prereq = new HashMap<>();

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        //first, populate the prereq map aka our adjacency list
        for(int[] pre: prerequisites) {
            prereq.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        //second, populate the prereq map for all numCourses
        for(int i = 0; i < numCourses; i++) {
            prereq.putIfAbsent(i, new ArrayList<>());
        }

        //third, process each query using DFS
        List<Boolean> result = new ArrayList<>();

        for(int[] query: queries) {

            int course = query[0];
            int target = query[1];

            result.add(dfs(course, target, new HashSet<>()));
        }

        return result;
    }


    public boolean dfs(int course, int target, Set<Integer> visited) {

        //if we reached the target, return true
        if(course == target) {
            return true;
        }

        //mark this course as visited
        visited.add(course);

        List<Integer> list = prereq.get(course);

        for(int pre: list) {

            //skip if already visited
            if(visited.contains(pre)) {
                continue;
            }

            //visit the next course
            if(dfs(pre, target, visited)) {
                return true;
            }
        }

        return false;
    }
}
