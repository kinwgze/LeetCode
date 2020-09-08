## Cisco2021校招编程题目

### 跳跃游戏 · Jump Game

##### 描述：

```
给出一个非负整数数组，你最初定位在数组的第一个位置。　　　

数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　

判断你是否能到达数组的最后一个位置。
```

题目来源及解析：https://www.jiuzhang.com/solutions/jump-game/#tag-lang-java

##### *样例一*

```
输入：[2 3 1 1 4]
输出：[true]
```

##### *样例二*

```
输入：[3 2 1 0 4]
输出：[false]
```



##### 动态规划：Java解题

###### 解题思路：

- 我们可以把该问题拆分成子问题，从前到后确定每个位置是否可达，用动态规划的思想求解。
- 建立`dp`数组，`dp[i]`表示能否跳到`i`位。
- 状态转移关系：
    - 如果存在某点`j`，`dp[j]`为`true`且从`j`可以跳到`i`，那么`dp[i]`为`true`
    - 否则，`dp[i]`为`false`

###### 复杂度分析：

- 时间复杂度：O(n<sup>2</sup>)，n为数组长度。双重遍历。
- 空间复杂度：O(n)，n为数组长度。建立的`dp[]`长度为`n`。

```java
public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        for (int i = 1; i < A.length; i ++) {
            for (int j = 0; j < i; j ++) {
                // 如果之前的j节点可达，并且从此节点可以到跳到i
                if (dp[j] && A[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[A.length - 1];
    }
}
```

