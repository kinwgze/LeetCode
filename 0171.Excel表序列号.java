//进制转换
class Solution {
    public int titleToNumber(String s) {
        int n = s.length() - 1;
        int res = 0;
        while (n >= 0) {
            int i = (int)s.charAt(n) - 64;
            res += (int)Math.pow(26, (s.length() - 1 - n)) * i;
            n --;
        }
        return res;
    }
}

//二
class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}

//Tips：
//如果记不清数字或者字母对应的ASCII码，就直接以他们的第一个为开始进行计算，如二中的- 'A' + 1
