package jiuzhang.dp;

import java.util.List;

/**
 * Created by fanjiangqi on 2017/5/31.
 * 思路：动态规划, f[x][y]，表示从起点出发到 (x,y)的最短距离
 * https://leetcode.com/problems/triangle/#/description
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] f = new int[rows][rows]; //表示从起点出发到(x,y)的最短距离
        f[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < rows; i++){
            List<Integer> list = triangle.get(i);
            for (int j =0; j < list.size(); j++){
                if (j == 0){
                    f[i][j] = f[i - 1][j] + list.get(j);
                }else if (j == list.size() - 1){
                    f[i][j] = f[i - 1][j - 1] + list.get(j);
                }else {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + list.get(j);
                }

            }
        }
        int min = f[rows - 1][0];
        for (int i = 0; i < rows; i++){
            if (f[rows - 1][i] < min){
                min = f[rows - 1][i];
            }
        }
        return min;
    }

    /**
     * 滚动数组，空间复杂度是O(n)，全部取模2
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] f = new int[2][rows]; //表示从起点出发到(x,y)的最短距离
        f[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < rows; i++){
            List<Integer> list = triangle.get(i);
            for (int j =0; j < list.size(); j++){
                if (j == 0){
                    f[i%2][j] = f[(i - 1)%2][j] + list.get(j);
                }else if (j == list.size() - 1){
                    f[i%2][j] = f[(i - 1)%2][j - 1] + list.get(j);
                }else {
                    f[i%2][j] = Math.min(f[(i - 1)%2][j], f[(i - 1)%2][j - 1]) + list.get(j);
                }

            }
        }
        int min = f[(rows-1)%2][0];
        for (int i = 0; i < rows; i++){
            if (f[(rows-1)%2][i] < min){
                min = f[(rows-1)%2][i];
            }
        }
        return min;
    }
}
