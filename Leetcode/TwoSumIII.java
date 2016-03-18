/*
public class TwoSum {

    // Add the number to an internal data structure.
    private ArrayList<Integer> list ;
    private HashMap<Integer, Integer> dict;
    public TwoSum() {
        list = new ArrayList<Integer>();
        dict = new HashMap<Integer, Integer>();
    }
	public void add(int number) {
	    list.add(number);
	    if (dict.containsKey(number)) {
	        dict.put(number, dict.get(number) + 1);
	    } else {
	        dict.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++) {
	        int num = list.get(i);
	        int delta = value - num;
	        if (delta == num) {
	            if (dict.containsKey(delta) && dict.get(delta) > 1) {
	                return true;
	            }
	        } else if (dict.containsKey(delta)) {
	            return true;
	        }
	    }
	    return false;
	}
}
*/

public class TwoSum {

    // Add the number to an internal data structure.
    private  ArrayList<Integer> list;
    private  HashSet<Integer> set;
    public TwoSum() {
        list = new ArrayList<Integer>();
        set = new HashSet<Integer>();
    }
	public void add(int number) {
	    for (int i =0; i < list.size(); i++) {
	        set.add(number + list.get(i));
	    }
	    list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return set.contains(value);
	}
}
