import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> hashMap;
    public LRUCache(int capacity) {
        hashMap = new LinkedHashMap<Integer, Integer>(capacity) {
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest ) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return hashMap.get(key);
    }

    public void set(int key, int value) {
        hashMap.put(key, value);
    }
}