public int numberOfPatterns(int m, int n) {
        int[][] jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        boolean[] visited = new boolean[10];
        int a =  dfs(1, 1, m,n, visited, jumps) * 4; //1, 3 ,7,9
        int b =  dfs(2, 1, m,n, visited, jumps) * 4;//2,4,6,8
        int c =  dfs(5, 1, m,n, visited, jumps);  //5
        return a + b + c;
    }

    public int dfs(int num, int index, int m, int n, boolean[] visited, int[][] jumps) {
        int count = 0;
        if (index >= m) {
            count++;
        }
        
        if (index < n) {
            visited[num] = true;
            for(int i = 1; i <= 9; i++) {
                int jump = jumps[num][i];
                if (!visited[i] && (jump == 0 || visited[jump])) {
                    count += dfs(i, index + 1, m, n, visited, jumps);
                }
            }
            visited[num] = false;
           
        }
	return count;
    }
