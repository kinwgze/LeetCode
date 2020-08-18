/*
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。

*/

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column --;
            } else {
                row ++;
            }
        }
        return false;
    }
}

/*
Tips：这道题不是从左上角开始，而是右上角，因为左上角只是代表这一行的起点，与上一行的最后一个数无关系。
从右上开始，如果比target大，则左移，否则直接下移。
*/