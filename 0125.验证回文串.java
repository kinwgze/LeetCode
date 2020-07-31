//我的思路：首先将原字符串中的字母和数字都提取出来，构建一个只有字母和数字的字符串，同时大写改小写
//然后验证该字符串是否为回文串
//my codes:
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if(('0' <= s.charAt(i) && s.charAt(i) <= '9') || ('a' <= s.charAt(i) && s.charAt(i) <= 'z')) {
                s2.append(s.charAt(i));
            } else if( 'A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                s2.append((char)(s.charAt(i) + 32));
            }
        }
        int m = s2.length() - 1, mid = s2.length() / 2 - 1;
        for (int j = 0; j <= mid; j ++) {
            if (s2.charAt(j) != s2.charAt(m - j)) {
                return false;
            }
        } 
        return true;
    }
}

//方法二：
//在原字符串上直接进行判断
class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}

/*
Tips：
1. Charact.isLetterOrDigit()用于判断一个字符是否为字母或者数字
同理 isLetter()和 isDigit()
2. 不管大小写。都可以使用toLowerCase()进行转换，确保小写
*/