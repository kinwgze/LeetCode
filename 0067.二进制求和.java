//方法一：
//最朴素的方法：先将 aa 和 bb 转化成十进制数，求和后再转化为二进制数。

//Integer.toBinaryString()方法
//作用是把一个10进制数转为32位的2进制数。同时对负数，会用补码表示。

//static int parseInt(String s) 
// 将字符串参数作为有符号的十进制整数进行分析。 

class Solution {
    public String addBinary(String a, String b) {        
        return Integer.toBinaryString(
            Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}


/**************************************************************/
//方法二：
//我们就按照小学算数那么来做，用 carry 表示进位，从后往前算，依次往前，
//每算出一位就插入到最前面即可，直到把两个二进制串都遍历完即可

//第一种写法：
class Solution {
    public String addBinary(String a, String b) {        
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            //ASCII码计算，将0 - 9的字符数字转换为十进制的数字 利用ascll值差距
            //比如array[i]的值为'2',那么array[i] - '0'就会等于2。
            //注意这里并不是简单的2 - 0的问题，是字符'2'的ASCII码值 减去字符'0'的ASCII码值
            carry += a.charAt(p1 --) - '0';   
            carry += b.charAt(p2 --) - '0';
            //这里采用的是逢二进一的思想
            sb.insert(0, (char)(carry % 2 + '0'));
            //保存进位
            carry >>= 1;   //向右移位运算时将运算的结果同时赋值给carry，也就是carry/2取整后的值重新赋值给carry
        }
        while (p1 >= 0) {
            carry += a.charAt(p1 --) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += b.charAt(p2 --) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}


//第二种写法：
class Solution {
    public String addBinary(String a, String b) {        
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        //这里用比较i和a b长度的方法去取值的方法，节省了判断是否还存在未处理的字符段
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {  
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}



/*
Tips：
StringBuilder的常见操作：

1、append(String str)/append(Char c)：字符串连接
System.out.println("StringBuilder:"+strB.append("ch").append("111").append('c'));
//return "StringBuilder:ch111c"

2、toString()：返回一个与构建起或缓冲器内容相同的字符串
System.out.println("String:"+strB.toString());
//return "String:ch111c"

3、appendcodePoint(int cp)：追加一个代码点，并将其转换为一个或两个代码单元并返回this
System.out.println("StringBuilder.appendCodePoint:"+strB.appendCodePoint(2));
//return "StringBuilder.appendCodePoint:ch111c"

4、setCharAt(int i, char c)：将第 i 个代码单元设置为 c（可以理解为替换）
strB.setCharAt(2, 'd');
System.out.println("StringBuilder.setCharAt:" + strB);
//return "StringBuilder.setCharAt:chd11c"

5、insert(int offset, String str)/insert(int offset, Char c)：在指定位置之前插入字符(串)
System.out.println("StringBuilder.insertString:"+ strB.insert(2, "LS"));
//return "StringBuilder.insertString:chLSd11c"
System.out.println("StringBuilder.insertChar:"+ strB.insert(2, 'L'));
//return "StringBuilder.insertChar:chLLSd11c"

6、delete(int startIndex,int endIndex)：删除起始位置（含）到结尾位置（不含）之间的字符串
System.out.println("StringBuilder.delete:"+ strB.delete(2, 4));
//return "StringBuilder.delete:chSd11c"


*/