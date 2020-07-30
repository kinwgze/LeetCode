//思路很简单，就是从头开始直接模拟
//主要点在于一开始没想起来使用StringBuilder

//直接模拟法
class Solution {
    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] ch = str.toCharArray();
            int times = 1;
            for (int j = 1; j < str.length(); j ++) {
                if (ch[j] == ch[j - 1]) {
                    times ++;
                } else {
                    sb.append(times).append(ch[j - 1]);
                    times = 1;
                }
            }
           str = sb.append(times).append(ch[str.length() - 1]).toString();
        }
        return str;
    }
}

//方法二：迭代法
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder res = new StringBuilder();
        String str = countAndSay(n - 1);
        int length = str.length();
        int a = 0;
        for (int i = 1; i < length + 1; i ++) {
            if (i == length) {
                return res.append(i - a).append(str.charAt(a)).toString();
            } else if (str.charAt(i) != str.charAt(a)) {
                res.append(i -a).append(str.charAt(a));
                a = i;
            }
        }
        return res.toString();
    }
}