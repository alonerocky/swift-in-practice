/*
public class LRUCache {
    private LinkedHashMap<Integer, Integer> hashMap;
    private int capacity;
    public LRUCache(int capacity) {
        hashMap = new LinkedHashMap<Integer, Integer>(2*capacity, 1.5f, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest ) {
                return size() > LRUCache.this.capacity;
            }
        };
        this.capacity =  capacity;
    }
    
    public int get(int key) {
        Integer value =  hashMap.get(key);
        if (value == null ) {
            return -1;
        }
        return value.intValue();
    }
    
    public void set(int key, int value) {
        hashMap.put(key, value);
    }
}
*/
/*

public class LRUCache {

    private HashMap<Integer, DoubleLinkedListNode<Integer, Integer>>  map;
    private DoubleLinkedListNode<Integer, Integer> header;
    private int capacity;
    public LRUCache(int capacity) {
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

     
    //add this to be before of node
     
    public void addBefore(DoubleLinkedListNode node) {
        next = node;
        prev = node.prev;
        prev.next = this;
        next.prev = this;

    }

    
    //add this to be after of node
     
    public void addAfter(DoubleLinkedListNode node) {
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
*/
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(2 * capacity, 1.5f, true);
        this.capacity = capacity;
    }
    public int get(int key) {
        Integer value = super.get(key);
        if (value == null) {
            return -1;
        }
        return value.intValue();
    }

    public void set(int key, int value) {
        super.put(key, value);
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > this.capacity;
    }
}
