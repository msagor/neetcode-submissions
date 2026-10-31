class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();

        Queue<Node> q1 = new LinkedList<>();

        // create clone of starting node
        Node nn = new Node(node.val);

        map.put(node.val, nn);

        q1.offer(node);

        while (!q1.isEmpty()) {

            // this original node
            Node n = q1.poll();

            // get the clone of this node
            nn = map.get(n.val);

            // populate nn neighbor list
            for (Node ln : n.neighbors) {

                Node ln_New;

                // if this neighbor has not been cloned
                if (!map.containsKey(ln.val)) {

                    // make a new clone
                    ln_New = new Node(ln.val);

                    // add clone to map
                    map.put(ln_New.val, ln_New);

                    // add ORIGINAL neighbor to queue
                    q1.offer(ln);

                } else {

                    // use already-created clone
                    ln_New = map.get(ln.val);
                }

                // connect current clone to neighbor clone
                nn.neighbors.add(ln_New);
            }
        }

        return map.get(node.val);
    }
}