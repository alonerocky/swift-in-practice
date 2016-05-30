package Facebook;

import com.sun.javafx.tk.Toolkit;

import java.util.*;

/**
 * Created by shoulongli on 5/25/16.
 */
public class TaskScheduler {

    public static void main(String[] argv) {

        TaskScheduler t = new TaskScheduler();
        System.out.println(t.taskSequence("AAABBB", 2).equals("A__A__AB__B__B"));
        System.out.println(t.timeForTaskSequence("AAABBB", 2) == ("A__A__AB__B__B".length()));
        System.out.println(t.taskSequenceOptimal("AAABBB", 2).equals("AB_AB_AB"));
        System.out.println(t.timeForTaskSequenceOptimal("AAABBB", 2) == ("AB_AB_AB".length()));

        System.out.println(t.taskSequence("ABCDAABA", 2).equals("ABCDA__AB_A"));
        System.out.println(t.timeForTaskSequence("ABCDAABA", 2) == ("ABCDA__AB_A".length()));
        System.out.println(t.taskSequenceOptimal("ABCDAABA", 2).equals("ABCABDA__A"));
        System.out.println(t.timeForTaskSequenceOptimal("ABCDAABA", 2) == ("ABCABDA__A".length()));

        System.out.println(t.taskSequence("AABABCD", 2).equals("A__AB_ABCD"));
        System.out.println(t.timeForTaskSequence("AABABCD", 2) == ("A__AB_ABCD".length()));
        System.out.println(t.taskSequenceOptimal("AABABCD", 2).equals("ABCABDA"));
        System.out.println(t.timeForTaskSequenceOptimal("AABABCD", 2) == ("ABCABDA".length()));
    }

    public String taskSequence(String tasks, int interval) {
        if (tasks == null || tasks.length() == 0 || interval <= 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();

        int current = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        while(i < tasks.length()) {
            char t = tasks.charAt(i);
            if (!map.containsKey(t) || map.get(t) + interval + 1 <= current) {
                //run task t
                map.put(t, current);
                sb.append(t);
                current++;
                i++;
            } else {
                //
                int idles = map.get(t) + interval + 1 - current;
                for (int j = 0; j < idles; j++) {
                    sb.append("_");
                }
                current += idles;
            }
        }


        return sb.toString();
    }
    public String taskSequenceI(String tasks, int interval) {
        if (tasks == null || tasks.length() == 0 || interval <= 0) {
            return "";
        }
        int current = 0;
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        while(i < tasks.length()) {
            char task = tasks.charAt(i);
            if (!map.containsKey(task) || current >= map.get(task)) {
                sb.append(task);
                map.put(task, current + 1 + interval);
                current++; //run task
                i++;
            } else {
                int idles = map.get(task) - current;
                for (int j = 0; j < idles; j++) {
                    sb.append("_");
                }

                current+=idles; //run idle
            }
        }
        return sb.toString();
    }

    public int timeForTaskSequence(String tasks, int interval) {
        if (tasks == null || tasks.length() == 0 || interval <= 0) {
            return 0;
        }
        int current = 0;
        int len = tasks.length();
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while( i < len) {
            char task = tasks.charAt(i);
            if (!map.containsKey(task) || current >= map.get(task)) {

                //run task
                i++;
                current++;
                map.put(task, current + interval);
            } else {
                int idles = map.get(task) - current;
                current += idles;
                //run idles
            }
        }
        return current;
    }

    public String taskSequenceOptimal(String tasks, int interval) {
        StringBuffer sb = new StringBuffer();
        if (tasks == null || tasks.length() == 0 || interval <= 0) {
            return sb.toString();
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < tasks.length(); i++) {
            char c = tasks.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {

            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(tasks.length() + 1, comparator);
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            maxHeap.offer(iterator.next());
        }

        //every time, try to get interval + 1  unique tasks to run

        while(!maxHeap.isEmpty()) {

            int n = Math.min(maxHeap.size(), interval + 1);
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(maxHeap.poll());
            }

            for (int i = 0; i < list.size(); i++) {
                Map.Entry<Character, Integer> entry = list.get(i);
                sb.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
            if (!maxHeap.isEmpty()) {
                for (int i = n; i < interval + 1; i++) {
                    sb.append("_");
                }
            }
        }
        return sb.toString();
    }

    public int timeForTaskSequenceOptimal(String tasks, int interval) {
        if (tasks == null || tasks.length() == 0 || interval <= 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        //get the frequency for each task
        int len = tasks.length();
        for (int i = 0; i < len; i++) {
            char t = tasks.charAt(i);
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }

        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        };

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(interval + 1, comparator);

        //put all those tasks into maxHeap
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();

        int current = 0;
        while(iterator.hasNext()) {
            maxHeap.offer(iterator.next());
        }

        //every time we "try to " get (interval + 1) unique tasks
        while(!maxHeap.isEmpty()) {

            int n = Math.min(maxHeap.size(), interval + 1);
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(maxHeap.poll());
            }

            for (int i = 0; i < n; i++) {
                Map.Entry<Character, Integer> entry = list.get(i);
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }
            current += n;
            if (!maxHeap.isEmpty()) {
                current += (interval +1 - n);
            }
        }
        return current;
    }


}
