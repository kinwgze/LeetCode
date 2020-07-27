//思路：从后往前，考虑进位
/*
题意是给你一个数字数组，高位在前，并且首位不为 0 除非这个数组就是 [0]，让你给该数组低位加一求其结果，那么我们就模拟小学数学那样进位去算即可，如果一直进位到首位，这种情况也就是都是由 9 组成的数组，此时我们只要 new 出一个多一个长度的数组即可，并把第 0 个元素赋 1 即可。
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        if (digits[n] < 9) {
            digits[n] = digits[n] + 1;
        } else {
            do {
                digits[n] = 0;   //digits[n]置为0，同时向上进一位
                n --;
            } while (n >= 0 && digits[n] == 9); //如果上一位仍然是9，重复进位操作
            if (digits[0] != 0) {  //如果第一位不是0，说明进位在中间就终止了，也就是n所指向的数字小于9
                digits[n] = digits[n] + 1;
            } else {   //如果第一位也是0，那么+1后的数字要比之前的数字多一位。需要重新建立数组。
                digits = new int[digits.length + 1];
                digits[0] = 1;  //Java中建立的新的int类型数组的默认值都为0。所以只需要个更改第一个值即可
            }
        }
        return digits;
    }
}

/*
Tips：
从后往前的时候思路要清晰。
第一步，判断最后一位是否为9，即是否需要进位，如果不需要，则直接加1即可
第二步，最后一位为9，需要进位，最后一位置为0，指针指向前一位，判断将其加1是否需要进位。
如果需要则置为0，指针-1，重复此操作，直至进位结束
第三步，判断首位是否为0，题意说明，初始值首位不为0，若此时为0，则全部进位，数组需要重新new，长度+1
若此时首位仍不为0，则进位在数组中间部位结束，此时指针指向的数字+1即可。
*/