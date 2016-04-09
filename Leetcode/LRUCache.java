import java.util.LinkedHashMap;
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
