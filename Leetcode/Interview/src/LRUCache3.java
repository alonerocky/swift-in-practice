import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by shoulongli on 4/10/16.
 */
public class LRUCache3 extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache3(int capacity) {
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
