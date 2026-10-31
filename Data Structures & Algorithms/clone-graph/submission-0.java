class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();

        Queue<Node> q1 = new LinkedList<>();

        // create clone of starting node
        Node clone = new Node(node.val);

        map.put(node.val, clone);

        q1.offer(node);

        while (!q1.isEmpty()) {

            // original node
            Node n = q1.poll();

            // get its already-created clone
            Node nn = map.get(n.val);

            // go through original node's neighbors
            for (Node ln : n.neighbors) {

                // if neighbor has not been cloned yet
                if (!map.containsKey(ln.val)) {

                    // create its clone
                    Node ln_New = new Node(ln.val);

                    // save the relationship
                    map.put(ln.val, ln_New);

                    // explore the ORIGINAL neighbor later
                    q1.offer(ln);
                }

                // connect current cloned node
                // to the neighbor's EXISTING clone
                nn.neighbors.add(map.get(ln.val));
            }
        }

        return clone;
    }
}