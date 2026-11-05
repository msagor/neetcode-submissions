
//needed help from chatgpt to fix issues in //here
class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {


        //first, populate the adjacency map two ways
        for(int[] e: edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]); //here - sincee its an undirected graph
        }

        Set<Integer> visited = new HashSet<>();

        //second, run dfs once from node 0
        //here - i was running dfs for all nodes, but we only need to dfs once from 0 sicne 0 is always the staring node.
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

        //here - do not delete node from visited,
        //since we need to detect cycle in the whole graph

        return true;
    }
}
