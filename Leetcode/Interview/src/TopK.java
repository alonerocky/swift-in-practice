import java.util.*;

/**
 * Created by shoulongli on 5/8/16.
 */
public class TopK {
    /*
    1, Top K Frequent Elements
    2, find Top K Frequent Words
    3, Top K pair

     */

    public static void main(String[] argv) {
        String str = "Welcome to the world of Geeks \n" +
                "This portal has been created to provide well written well thought and well explained \n" +
                "solutions for selected questions If you like Geeks for Geeks and would like to contribute \n" +
                "here is your chance You can write article and mail your article to contribute at \n" +
                "geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help \n" +
                "thousands of other Geeks";
        TopK topK = new TopK();
        System.out.println(topK.findTopKWords(str, 5));
    }
    public List<String> findTopKWords(String str, int k) {
        List<String> result = new ArrayList<>();
        String[] words = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, comparator);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            minHeap.offer(iterator.next());
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty()) {
            Map.Entry<String, Integer> entry = minHeap.poll();
            System.out.println(entry.getKey()+" : "+entry.getValue());
            result.add(0, entry.getKey());
        }
        return result;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry1.getValue() - entry2.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>> (k, comparator);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();

            if (minHeap.size() < k) {
                minHeap.offer(entry);

            } else if (comparator.compare(entry, minHeap.peek()) > 0) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        while(!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }
        return result;
    }
}
