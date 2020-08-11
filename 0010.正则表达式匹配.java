//没太看懂。。。。。
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; ++ i) {
            for (int j = 1; j <= n; ++ j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}







/*
Tips：
正常的正则表达式的用法

要注意正则表达式在Java代码中也是一个字符串，所以，对于正则表达式a\&c来说，
对应的Java字符串是"a\\&c"，因为\也是Java字符串的转义字符，两个\\实际上表示的是一个\

一：基本用法
1. 用 .  匹配任意字符   如 a.c    可以匹配一个字符且仅限一个字符
2. 用 \d 匹配任意数字   如 00\d   仅限单个数字字符。
3. 用 \w 可以匹配一个字母、数字或下划线，w的意思是word。  如java\w。 但是不能匹配# 空格等字符。
4. 用 \s 匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符（在Java中用\t表示）。
5. 用 \D 匹配一个非数字。同理，存在 \W 和 \S 
6. \u548c	指定Unicode字符，可以匹配汉字。


二：重复匹配
1. 修饰符*可以匹配任意个字符，包括0个字符。 如A\d*
2. 修饰符+可以匹配至少一个字符。 如A\d+
3. 修饰符?可以匹配0个或一个字符。 如A\d?
4. 用修饰符{n}就可以精确指定n个字符。 如A\d{3}
5. 用修饰符{n,m}就可以指定匹配n~m个字符。 如A\d{3,5}
6. A{n,} 至少n个字符
7. A{0,n}	最多n个字符

三：复杂匹配规则
1. 匹配开头和结尾
   用正则表达式进行多行匹配时，我们用^表示开头，$表示结尾。例如，^A\d{3}$，可以匹配"A001"、"A380"
2. 匹配指定规则
   使用[...]可以匹配范围内的字符，例如，[123456789]可以匹配1~9，这样就可以写出上述电话号码的规则：[123456789]\d{6,7}。
   把所有字符全列出来太麻烦，[...]还有一种写法，直接写[1-9]就可以。
   要匹配大小写不限的十六进制数，比如1A2b3c，我们可以这样写：[0-9a-fA-F]。0-9：字符0~9；a-f：字符a~f；A-F：字符A~F
   [...]还有一种排除法，即不包含指定范围的字符。假设我们要匹配任意字符，但不包括数字，可以写[^1-9]{3}
3. 规则匹配
   用|连接的两个正则规则是或规则，例如，AB|CD表示可以匹配AB或CD
4. 括号的使用
   现在我们想要匹配字符串learn java、learn php和learn go怎么办？
   一个最简单的规则是learn\sjava|learn\sphp|learn\sgo，但是这个规则太复杂了，可以把公共部分提出来，
   然后用(...)把子规则括起来表示成learn\\s(java|php|go)。

四：分组匹配和其他正则表达式见
    https://www.liaoxuefeng.com/wiki/1252599548343744/1306046706483233
*/