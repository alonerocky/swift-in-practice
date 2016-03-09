private enum Direction  {UP_DOWN, DOWN_UP, LEFT_RIGHT, RIGHT_LEFT};
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) {
            return result;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = rows * columns;
        Direction direction = Direction.LEFT_RIGHT;
        //current row, column
        int row = 0;
        int column = 0;
        //boundry 
        int top = 0;
        int bottom = rows - 1;
        int left = 0; 
        int right = columns - 1;
        
        int i = 0;
        while (i < count) {
            result.add(matrix[row][column]);
            i++;
            switch(direction) {
                case LEFT_RIGHT:
                    if (column == right) {
                        row++;
                        top++;
                        direction = Direction.UP_DOWN;
                    } else {
                        column++;
                    }
                    break;
                case RIGHT_LEFT:
                    if (column == left) { //down -> up
                        row--;
                        bottom--;
                        direction = Direction.DOWN_UP;
                    } else {
                        column--;
                    }
                    break;
                case UP_DOWN:
                    if (row == bottom) {
                        column--;
                        right--;
                        direction = Direction.RIGHT_LEFT;
                    } else {
                        row++;
                    }
                    break;
                case DOWN_UP:
                    if (row == top) {
                        column++;
                        left++;
                        direction = Direction.LEFT_RIGHT;
                    } else {
                        row--;
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }
