//一开始思路很简单，switch case无限判断。
//这样虽然耗时不长，但是代码十分冗长。多重嵌套判断。问题很大。
//仔细观察罗马数字与整数的转换规律可以得到。当小的数字在大的数字左边的时候，
//可以理解为这个小的数字为负的，比如IV 实际上可以看成 -1 和 5。相加仍为4

/*
解题思路：
1. 罗马数字由 I,V,X,L,C,D,M 构成；
2. 当小值在大值的左边，则减小值，如 IV=5-1=4；
3. 当小值在大值的右边，则加小值，如 VI=5+1=6；
4. 由上可知，右值永远为正，因此最后一位必然为正。

简言之，把一个小值放在大值的左边，就是做减法，否则为加法。

在代码实现上，可以往后看多一位，对比当前位与后一位的大小关系，从而确定当前位是加还是减法。
当没有下一位时，做加法即可。

也可保留当前位的值，当遍历到下一位的时，对比保留值与遍历位的大小关系，
再确定保留值为加还是减。最后一位做加法即可。
*/


class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i ++){
            int num = getValue(s.charAt(i));
            if (num > preNum) {
                result = result - preNum;
            } else {
                result += preNum;
            }
            preNum = num;
        }  
        result += preNum;  
        return result;  
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}

/*
Tips: 
1. s.charAt(Index) 可以直接取出索引为index的数值，而不需要再转换为char数组再计算
2. 这道题每次只考虑一位即可。不需要考虑对后一位的计算，仅需要后一位来判断前一位的正负，
如果再考虑到后一位的加减，会让这个算法变得复杂，
3. 代码要求简洁易懂，所以如果某一段里面重复用到某个函数的结果，可以直接将其计算出来，
使用变量指向这个结果，在增加代码可读性的同时还能减少运行时间。
*/



//my codes, stupid codes
class Solution {
    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int result = 0;
        for (int i = 0; i < roman.length; i ++) {
            switch (roman[i]) {
                case 'I' : {
                    if (i != roman.length - 1 && roman[i + 1] == 'V'){
                        result += 4;
                        i ++;
                    } else if (i != roman.length - 1 && roman[i + 1] == 'X') {
                        result += 9;
                        i ++;
                    } else {
                        result += 1;
                    }
                    break;
                }
                case 'V' : {
                    result += 5;
                    break;
                }
                case 'X' : {
                    if (i != roman.length - 1 && roman[i + 1] == 'L') {
                        result += 40;
                        i ++;
                    } else if (i != roman.length - 1 && roman[i + 1] == 'C') {
                        result += 90;
                        i ++;
                    } else {
                        result += 10;
                    }
                    break;
                }
                case 'L' : {
                    result += 50;
                    break;
                }
                case 'C' : {
                    if (i != roman.length - 1 && roman[i + 1] == 'D') {
                        result += 400;
                        i ++;
                    } else if (i != roman.length - 1 && roman[i + 1] == 'M') {
                        result += 900;
                        i ++;
                    } else {
                        result += 100;
                    }
                    break;
                }
                case 'D' : {
                    result += 500;
                    break;
                }
                case 'M' : {
                    result += 1000;
                    break;
                }
            }
        }
        return result;
    }
}