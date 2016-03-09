private enum Direction { LEFT_RIGHT, RIGHT_LEFT, UP_DOWN, DOWN_UP };
    public int[][] generateMatrix(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n ==0) {
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        
        int i = 1;
        int count = n * n;
        
        //current row, column
        int row = 0;
        int column = 0;
        
        //direction
        Direction direction = Direction.LEFT_RIGHT;
        
        //range
        int top = 0;
        int bottom = result.length - 1;
        int left = 0;
        int right = result[0].length - 1;
        while (i <= count) {
            
            result[row][column] = i;
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
                case UP_DOWN:
                    if (row == bottom) {
                        column--;
                        right--;
                        direction = Direction.RIGHT_LEFT;
                    } else {
                        row++;
                    }
                    break;
                case RIGHT_LEFT:
                    if (column == left) {
                        row--;
                        bottom--;
                        direction = Direction.DOWN_UP;
                    } else {
                        column--;
                    }
                    break;
                case DOWN_UP:
                    if (row == top) {
                        direction = Direction.LEFT_RIGHT;
                        left++;
                        column++;
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
