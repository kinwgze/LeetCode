
//这道题思路用的是栈，利用栈进行暂时存储，然后匹配各种符号。

//my codes
class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        int n = s.length();
        for (int i = 0; i < n; i ++){
            if( !stack.empty() && isMatch((char)stack.peek(), s.charAt(i))){ //如果栈不为空，且栈顶与 当前符号匹配
                stack.pop();
            } else {  //栈为空，或栈顶与当前符号不匹配，入栈。
                stack.push(s.charAt(i));
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMatch(char c1, char c2) { //是否匹配函数
        switch (c1) {
            case '(' : {
                if (c2 == ')') {
                    return true;
                } else {
                    return false;
                }
            }           
            case '{' : {
                if (c2 == '}') {
                    return true;
                } else {
                    return false;
                }
            }            
            case '[' : {
                if (c2 == ']') {
                    return true;
                } else {
                    return false;
                }
            }
            default : return false;
        }
    }
}

//优化解
/*
使用栈是正确的思路。但是可以进行优化，
当我们遇到左括号的时候，我们无法判断是否与前面的相匹配。只有见到右括号的时候，我们才能进行匹配判断
也就是说，我们遇到左括号的时候，直接将其入栈，遇到右括号的时候，再与栈顶进行匹配，可以优化代码

出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，
不匹配的话直接返回 false 即可，最终判断是否空栈即可，
这里我们可以用数组模拟栈的操作使其操作更快，有个细节注意下 top = 1;，
从而省去了之后判空的操作和 top - 1 导致数组越界的错误。


*/


class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }
}

/*
Tips：
对于这种简单的栈操作，使用数组模拟的时候要比直接使用栈代码简洁易懂。且时间短
*/