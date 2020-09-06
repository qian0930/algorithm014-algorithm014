package com.hbq.aop.algorithm.week04;

public class NumIslands {
        public int numIslands(char[][] grid) {
            if (null == grid || 0 == grid.length) {
                return 0;
            }
            int lr = grid.length;
            int lc = grid[0].length;

            int num = 0;
            for (int i = 0; i < lr; i++) {
                for (int j = 0; j < lc; j++) {
                    if ('1' == grid[i][j]) {
                        num++;
                        findIsland(grid, i, j);
                    }
                }
            }
            return num;
        }

        public void findIsland(char[][] grid, int r, int c) {
            int lr = grid.length;
            int lc = grid[0].length;
            if (r < 0 || r >= lr || c < 0 || c >= lc || '0' == grid[r][c]) {
                return;
            }
            grid[r][c] = '0';
            findIsland(grid, r - 1, c);
            findIsland(grid, r + 1, c);
            findIsland(grid, r, c - 1);
            findIsland(grid, r, c + 1);
        }
}
