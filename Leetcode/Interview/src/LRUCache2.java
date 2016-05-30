import com.sun.istack.internal.NotNull;

import java.util.HashMap;

/**
 * Created by shoulongli on 4/9/16.
 */
public class LRUCache2 {

    private HashMap<Integer, DoubleLinkedListNode<Integer, Integer>>  map;
    private DoubleLinkedListNode<Integer, Integer> header;
    private int capacity;
    public LRUCache2(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        header = new DoubleLinkedListNode<>();
        header.next = header;
        header.prev = header;
    }

    public int get(int key) {
        DoubleLinkedListNode<Integer, Integer> entry = map.get(key);
        if (entry != null) {
            entry.remove();
            entry.addAfter(header); //make entry the latest recent visited
            return entry.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        DoubleLinkedListNode<Integer, Integer> entry = new DoubleLinkedListNode<>(key, value);
        if (map.containsKey(key)) {
            DoubleLinkedListNode<Integer, Integer> existOne = map.get(key);
            existOne.remove();
            map.remove(key);
        }
        map.put(key, entry);
        entry.addAfter(header);
        if (map.size() > capacity) {
            removeEldestElement();
        }
    }

    public void removeEldestElement() {
        if (header.prev != header) {
            map.remove(header.prev.key);
            header.prev.remove();
        }
    }

    public static void main(String[] argv) {
        LRUCache2 lru = new LRUCache2(1);//1,[set(2,1),get(2),set(3,2),get(2),get(3)]
        lru.set(2,1);
        lru.get(2);
        lru.set(3,2);
        lru.get(2);
        lru.get(3);
    }
}

class DoubleLinkedListNode<K, V> {
    public K key;
    public V value;
    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;
    public DoubleLinkedListNode() {
        key = null;
        value = null;
    }

    public DoubleLinkedListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /*
    add this to be before of node
     */
    public void addBefore(@NotNull DoubleLinkedListNode node) {
        next = node;
        prev = node.prev;
        prev.next = this;
        next.prev = this;

    }

    /*
    add this to be after of node
     */
    public void addAfter(@NotNull DoubleLinkedListNode node) {
        prev = node;
        next = node.next;
        prev.next = this;
        next.prev = this;
    }

    public void remove() {
        prev.next = next;
        next.prev = prev;
        prev = next = null;
    }


}