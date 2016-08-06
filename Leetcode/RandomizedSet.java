public class RandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
         if (map.containsKey(val)) {
              int lastOne = list.get(list.size() - 1);
              int lastIndex = map.get(lastOne);
              
              int index = map.get(val);
              list.set(index, lastOne);
              map.put(lastOne, index);
              
              map.remove(val);
              list.remove(list.size() - 1);
              return true;
         }
         return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if (list.size() == 0) {
            return 0;
        }
        int i = new Random().nextInt(list.size());
        return list.get(i);
    }
    
    private void swap(ArrayList<Integer> list, int i, int j) {
        if (i != j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}
