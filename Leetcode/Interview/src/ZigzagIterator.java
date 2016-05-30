import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    private int row = 0;
    private int column = 0;
    private ArrayList<List<Integer>> vec2d;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vec2d = new ArrayList<List<Integer>>();
        if (v1.size() > 0) {
            vec2d.add(v1);
        }
        if (v2.size() > 0) {
            vec2d.add(v2);
        }
    }

    public int next() {
        List<Integer> current = vec2d.get(row);
        int result = current.get(column);
        if (column == current.size() -1) {
            vec2d.remove(row);//after remove this row. row will point to the next row
        } else {
            row++;
        }
        if (row == vec2d.size()) {
            row = 0;
            column++;
        }
        return result;
    }

    public boolean hasNext() {
        return vec2d.size() > 0 && column < vec2d.get(row).size();
    }

    public static void main(String[] argv) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(3);
        ZigzagIterator iterator = new ZigzagIterator(l1, l2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next()+" ,");
        }
    }
}