package Uber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by shoulongli on 5/30/16.
 */
public class TimeTravelingHashTable<K, V, T> {

    public static void main(String[] argv) {
        TimeTravelingHashTable<String, String, Integer> map = new TimeTravelingHashTable<String, String, Integer>();
        /**
         * * insert("k1", "v1", 10)
         * get("k1") // returns "v1"
         * get("k1", 11) // returns "v1"
         *
         * insert("k1", "v2", 20)
         * get("k1", 15) // returns "v1"
         * get("k1", 11) // returns "v1"
         * get("k1", 21)....
         */
        map.put("k1","v1",10);
        System.out.println(map);
        System.out.println("v1".equals(map.get("k1")));
        System.out.println(map.get("k1",9) == null);
        System.out.println("v1".equals(map.get("k1",10)));
        System.out.println("v1".equals(map.get("k1",11)));
        System.out.println("v1".equals(map.get("k1", 20)));

        map.put("k1", "v2", 20);
        System.out.println(map);
        System.out.println("v2".equals(map.get("k1")));
        System.out.println(map.get("k1",9) == null);
        System.out.println("v1".equals(map.get("k1",10)));
        System.out.println("v1".equals(map.get("k1",11)));
        System.out.println("v2".equals(map.get("k1", 20)));



        map.remove("k1");
        System.out.println(map);
    }

    private HashMap<K, TreeMap<T, V>>  map = new HashMap<>();
    /**
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        } else {
            Map.Entry<T, V> entry =  map.get(key).lastEntry();
            if (entry != null) {
                return entry.getValue();
            }
            return null;
        }
    }

    /**
     *
     * @param key
     * @param time
     * @return
     */
    public V get(K key, T time) {
        if (!map.containsKey(key)) {
            return null;
        } else {
            Map.Entry<T, V> entry = map.get(key).floorEntry(time);
            if (entry != null) {
                return entry.getValue();
            }
            return null;
        }
    }

    /**
     *
     * @param key
     * @param value
     * @param time
     * @return return the previous value associated with key, null if no that key
     */
    public V put(K key, V value, T time) {
        if (map.containsKey(key)) {
            return map.get(key).put(time, value);
        } else {
            TreeMap<T, V> treeMap = new TreeMap<>();
            treeMap.put(time, value);
            map.put(key, treeMap);
            return null;
        }
    }

    /**
     *
     * @param key
     * @param time
     * @return
     */
    public V remove(K key, T time) {
        if (map.containsKey(key)) {
            V value =  map.get(key).remove(time);
            if (map.get(key).size() == 0) {
                map.remove(key);
            }
        }
        return null;
    }


    /**
     *
     * @param key
     * @return
     */
    public TreeMap<T, V> remove(K key) {
        if (map.containsKey(key)) {
            return map.remove(key);
        }
        return null;
    }

    @Override
    public String toString() {

        return map.toString();
    }
}
