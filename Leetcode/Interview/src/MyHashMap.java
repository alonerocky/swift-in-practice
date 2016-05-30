import java.util.Map;

/**
 * Created by shoulongli on 5/21/16.
 */
public class MyHashMap<K, V> {

    public static final int DEFAULT_CAPACITY = 16;
    private int capacity;
    private Entry<K, V>[] table;
    private int size;

    public static void main(String[] argv) {

        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        map.put(1, 2);
        System.out.println(map.get(1) == 2);
        System.out.println(map.get(2) == null);
        System.out.println(map.put(1, 3) == 2);
        System.out.println(map.get(1) == 3);
        System.out.println(map.get(2) == null);
    }
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];

    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }
        int h = hash(key.hashCode());
        int index = indexOf(h, capacity);
        Entry<K, V> e = table[index];
        while(e != null) {
            if (e.hash == h &&
                    (key == e.key || key.equals(e.key))) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    public V getForNullKey() {
        Entry<K, V> e = table[0];
        while(e != null) {
            if (e.key == null) {
                return e.value;
            }
        }
        return null;
    }

    public V putForNullKey(V value) {
        Entry<K, V> e = table[0];
        while(e != null) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
            e = e.next;
        }
        addEntry(0, null, value, 0);
        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }

        int h = hash(key.hashCode());
        int index = indexOf(h, capacity);
        Entry<K, V> e = table[index];
        while(e != null) {
            if (e.hash == h &&
                    (key == e.key || key.equals(e.key))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
            e = e.next;
        }
        addEntry(index, key, value, h);
        return null;
    }

    public int size() {
        return size;
    }

    private void addEntry( int index, K key, V value, int hash) {
        Entry<K, V> e = new Entry<>(key, value, hash, table[index]);
        table[index] = e;
        size++;
        //TODO
        //resize the table if the size is bigger than the threashold
        resize(2 * capacity);
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexOf(int h, int length) {
        return h % length;
    }

    private void resize(int newCapacity) {
        this.capacity = newCapacity;
        Entry[] newTable = new Entry[this.capacity];
        //move all the old entries into new table
        Entry[] src = table;
        for (int i = 0; i < src.length; i++) {
            Entry<K, V> e = src[i];
            while (e != null) {
                src[i] = null;
                Entry<K, V> one = e;
                e = e.next;
                int index = indexOf(one.hash, newCapacity);
                one.next = newTable[index];
                newTable[index] = one;
            }

        }
        table = newTable;
    }

}

class Entry<K, V> {
    final K key;
    V value;
    Entry<K, V> next;
    int hash;

    public Entry(K key, V value, int hash, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

}
