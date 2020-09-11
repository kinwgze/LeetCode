### Offer29.顺时针打印矩阵

##### 描述：

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

##### 示例 1：

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
```

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int[] res = new int[matrix.length * matrix[0].length];
        /**
        * u代表的可遍历范围里面的上顶
        * d代表的可遍历范围里面的下底
        * l代表的可遍历范围里面的左边缘
        * r代表的可遍历范围里面的右边缘
        */
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1; 
        int idx = 0;

        while (true) { 
            for (int i = l; i <= r; i ++) { 
                res[idx ++] = matrix[u][i];
            }
            if (++ u > d) { 
                break;
            }
            for (int i = u; i <= d; i ++) { 
                res[idx ++] = matrix[i][r];
            }
            if (--r < l) {  
                break; 
            }
            for (int i = r; i >= l; i --) { 
                res[idx ++] = matrix[d][i];
            }
            if (-- d < u) {
                break;
            }
            for (int i = d; i >= u; i --) {
                res[idx ++] = matrix[i][l];
            }
            if (++ l > r) {
                break;
            }
        }
        return res;
    }
}
```

