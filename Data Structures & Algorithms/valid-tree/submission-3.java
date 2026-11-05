class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {


        //first, populate the adjacency map two ways
        for(int[] e: edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();

        //second, run dfs once from node 0
        if(!dfs(0, -1, visited)){
            return false;
        }

        return visited.size()==n;
    }

    public boolean dfs(int node, int parent, Set<Integer> visited){
        //check if node in visited already
        if(visited.contains(node)){
            return false;
        }

        //add this node to visited
        visited.add(node);

        if(!map.containsKey(node)){
            //no children of this node so return true
            return true;
        }

        //get the children of this node
        List<Integer> children = map.get(node);


        //run children thru dfs
        for(int c: children){
            if(c!=parent && !dfs(c, node, visited)){
                return false;
            }
        }

        return true;
    }
}
