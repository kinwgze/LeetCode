class Solution {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1: si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1: sj - 8);
    }
}



/*
以下代码为增量公式的三元表达式写法，将整合入最终代码中。
(x + 1) % 10 != 0 ? s_x + 1 : s_x - 8

遇到进位的时候，他们的数位和差8
    比如 19  数位和为10
    进位后是20，数位和是2 
    两者差8
*/
