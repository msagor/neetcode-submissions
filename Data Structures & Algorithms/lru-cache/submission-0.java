// Doubly linked list node used to store key-value pairs
// We use a doubly linked list because we need O(1) removal and insertion
//solution from Solution, did not implement myself


//initially  we keep left.next = right and right.prev = left
public class Node {

    int key;        // Stores the cache key
    int val;        // Stores the cache value

    Node prev;      // Points to previous node in linked list
    Node next;      // Points to next node in linked list

    // Constructor creates a new node with given key and value
    public Node(int key, int val) {
        this.key = key;       // Initialize key
        this.val = val;       // Initialize value

        this.prev = null;     // Initially no previous node
        this.next = null;     // Initially no next node
    }
}


public class LRUCache {

    private int cap;                     // Maximum number of items cache can store

    // HashMap gives O(1) lookup by key
    // key -> Node address in linked list
    private HashMap<Integer, Node> cache;


    // Dummy left node represents the beginning of linked list
    // The node after left is the least recently used item
    private Node left;


    // Dummy right node represents the end of linked list
    // The node before right is the most recently used item
    private Node right;



    // Constructor initializes an empty LRU Cache
    public LRUCache(int capacity) {

        this.cap = capacity;              // Store maximum cache size

        this.cache = new HashMap<>();     // Create empty hashmap


        // Create dummy nodes
        // These nodes do not store actual cache data
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);


        // Connect left and right initially
        //
        // left <----> right
        //
        this.left.next = this.right;
        this.right.prev = this.left;
    }



    /*
        Removes a node from the doubly linked list.

        Before:
        
        prev <----> node <----> next


        After:

        prev <----> next


        We only change pointers.
        HashMap is not modified here.
    */
    private void remove(Node node) {

        Node prev = node.prev;    // Store previous node
        Node nxt = node.next;     // Store next node


        // Skip over current node
        prev.next = nxt;

        // Connect next node back to previous node
        nxt.prev = prev;
    }



    /*
        Inserts a node at the end of linked list.

        The end represents MOST RECENTLY USED.

        Before:

        left ... previous <----> right


        After:

        left ... previous <----> node <----> right


        Newly used nodes always go to the right.
    */
    private void insert(Node node) {


        // Get the current last node
        Node prev = this.right.prev;


        // Connect previous last node to new node
        prev.next = node;


        // Connect new node backward
        node.prev = prev;


        // Connect new node forward to right dummy node
        node.next = this.right;


        // Connect right dummy node backward to new node
        this.right.prev = node;
    }




    /*
        Get value associated with key.

        If key exists:
        1. Find node using HashMap O(1)
        2. Move node to most recently used position
        3. Return value


        If key does not exist:
        Return -1
    */
    public int get(int key) {


        // Check if key exists in cache
        if (cache.containsKey(key)) {


            // Retrieve node from HashMap
            Node node = cache.get(key);


            // Remove node from its current position
            // because accessing it makes it recently used
            remove(node);


            // Insert it at the end (MRU position)
            insert(node);


            // Return stored value
            return node.val;
        }


        // Key not found
        return -1;
    }




    /*
        Insert or update a key-value pair.

        Cases:

        1. Key already exists:
           - Remove old node
           - Add updated node as most recently used


        2. Key does not exist:
           - Add new node


        3. If capacity exceeded:
           - Remove least recently used node
    */
    public void put(int key, int value) {


        // If key already exists
        if (cache.containsKey(key)) {


            // Remove old node from linked list
            // because we will replace it with updated value
            remove(cache.get(key));
        }



        // Create a new node with updated key-value pair
        Node newNode = new Node(key, value);



        // Store node in HashMap
        // Allows O(1) lookup later
        cache.put(key, newNode);



        // Add new node at end
        // because newly inserted items are most recently used
        insert(newNode);




        // If cache size exceeds capacity
        if (cache.size() > cap) {


            // The node after left dummy is least recently used
            Node lru = this.left.next;



            // Remove LRU node from linked list
            remove(lru);



            // Remove LRU key from HashMap
            cache.remove(lru.key);
        }
    }
}