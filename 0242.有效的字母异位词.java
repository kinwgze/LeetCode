//看到这道题，想到的是先排序，然后比较
//思路没问题，但是我想的是，这是一道简单题，而且单词一般不会很长，直接使用简单的冒泡排序
//但是，超时了。。。


//方法一：排序
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
//能直接用sort函数我是没想到的。。。。

/**************************************************************/

//方法二：哈希表
/*
为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。

我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，
用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

/*
改进：
或者我们可以先用计数器表计算 ss，然后用 tt 减少计数器表中的每个字母的计数器。
如果在任何时候计数器低于零，我们知道 tt 包含一个不在 ss 中的额外字母，并立即返回 FALSE。
*/
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] table = new int[26];
    for (int i = 0; i < s.length(); i++) {
        table[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
        table[t.charAt(i) - 'a']--;
        if (table[t.charAt(i) - 'a'] < 0) {
            return false;
        }
    }
    return true;
}


/*
Tips:
在将char[]转换为String，并返回的时候，如果直接使用toString()可能会出现返回值类似于[C@10f87f48的问题
此时应该使用return new String(char[])的格式
*/
