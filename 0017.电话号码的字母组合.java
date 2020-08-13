//回溯

/*
回溯是一种通过穷举所有可能情况来找到所有解的算法。如果一个候选解最后被发现并不是可行解，
回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。

给出如下回溯函数 backtrack(combination, next_digits) ，它将一个目前已经产生的组合 combination 和
接下来准备要输入的数字 next_digits 作为参数。

如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。
如果还有数字需要被输入：
遍历下一个数字所对应的所有映射的字母。
将当前的字母添加到组合最后，也就是 combination = combination + letter 。
重复这个过程，输入剩下的数字： backtrack(combination + letter, next_digits[1:]) 。
*/

class Solution {
    Map<String, String> phone = new HashMap<>() {
        {
            put("2","abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");

        }
    };

    List<String> output = new ArrayList<>();

    public void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i ++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;

    }
}


/*
Tips：

public String substring(int beginIndex)

返回一个新字符串，它是此字符串的一个子字符串。该子字符串始于指定索引处的字符，一直到此字符串末尾。

参数：beginIndex - 开始处的索引（包括），

返回：指定的子字符串，

*/