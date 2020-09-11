### Offer31.栈的压入、弹出序列

##### 描述：

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof

##### 示例：

```
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
```

##### 思路：

考虑借用一个辅助栈 `stackstack` ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。

**入栈操作：** 按照压栈序列的顺序执行。
**出栈操作：** 每次入栈后，循环判断 `“栈顶元素 == 弹出序列的当前元素”` 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
```

