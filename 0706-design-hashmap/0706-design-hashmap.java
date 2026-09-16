class MyHashMap {

    class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] map = new Node[1001];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        int i = key % 1001;

        if (map[i] == null) {
            map[i] = new Node(key, value);
            return;
        }

        Node curr = map[i];

        while (true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }

            if (curr.next == null) break;
            curr = curr.next;
        }

        curr.next = new Node(key, value);
    }

    public int get(int key) {
        int i = key % 1001;
        Node curr = map[i];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int i = key % 1001;
        Node curr = map[i];

        if (curr == null) return;

        if (curr.key == key) {
            map[i] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}