package Algorithms.Lesson6;
class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node[] table;
    private int size;
    private int capacity;
    private static class Node {
        int key;
        int value;
        Node next;
        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public MyHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Node[capacity];
        this.size = 0;
    }
    public void put(int key, int value) {
        int index = hash(key) % capacity;

        if (table[index] == null) {
            table[index] = new Node(key, value, null);
            size++;
        } else {
            Node current = table[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Node(key, value, null);
            size++;
        }

        if ((float)size / capacity > LOAD_FACTOR) {
            resize();
        }
    }
    public int get(int key) {
        int index = hash(key) % capacity;

        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }
    public void remove(int key) {
        int index = hash(key) % capacity;
        if (table[index] == null) {
            return;
        }
        if (table[index].key == key) {
            table[index] = table[index].next;
            size--;
            return;
        }
        Node current = table[index];
        Node previous = null;
        while (current != null) {
            if (current.key == key) {
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
    private int hash(int key) {
        key = ((key >>> 16) ^ key) * 0x45d9f3b;
        key = ((key >>> 16) ^ key) * 0x45d9f3b;
        key = (key >>> 16) ^ key;
        return Math.abs(key);
    }
    private void resize() {
        int newCapacity = capacity * 2;
        Node[] newTable = new Node[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Node current = table[i];
            while (current != null) {
                Node next = current.next;
                int newIndex = hash(current.key) % newCapacity;

                current.next = newTable[newIndex];
                newTable[newIndex] = current;

                current = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }
}
