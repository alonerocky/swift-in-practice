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
            //row maybe is the last row
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
}


public class ZigzagIterator { 
    private List<Iterator<Integer>> iterators;
    private int row = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new ArrayList<Iterator<Integer>>();
        if (v1 != null && v1.size() > 0) {
            iterators.add(v1.iterator());
        }
        if (v2 != null && v2.size() > 0) {
            iterators.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iterator = iterators.get(row);
        int result = iterator.next();
        if (iterator.hasNext()) {
            row++;
        } else {
            iterators.remove(row);
        }
        if (row == iterators.size()) {
            row = 0;
        }
        return result;
    }

    public boolean hasNext() {
         return iterators.size() > 0;
    }
}
