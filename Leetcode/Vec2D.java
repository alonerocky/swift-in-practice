public class Vector2D {
    private int row = 0; 
    private int column = 0;
    int i = 0;
    private int rows = 0;
    private int total = 0;
    private List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        if (vec2d != null) {
            for (int i =0 ; i < vec2d.size();i++) {
                List<Integer> current = vec2d.get(i);
                total += (current == null ? 0 : current.size());
            }
        }
    }

    public int next() {
        while (vec2d.get(row) == null || vec2d.get(row).size() == 0) {
            row ++;
            column = 0;
        }
        int result = vec2d.get(row).get(column);
        i++;
        column++;
        if (column == vec2d.get(row).size()) {
            row++;
            column = 0;
        }
        return result;
    }

    public boolean hasNext() {
        return i < total;
    }
}
