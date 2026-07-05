class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    private class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        moveToHead(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            moveToHead(cur);
        } else {
            if (map.size() == capacity) {
                Node t = tail.prev;
                map.remove(t.key);
                removeNode(t);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        if (node == head) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
