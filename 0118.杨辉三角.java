//思路：这道题的思路很简单，做法很很简单。主要问题在于对Java中的list不会使用，导致使用int[]作为过渡。
//这就导致了代码的冗长，虽然通过了测试。但是代码不简洁

//正确答案：
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> upSub = list.get(i - 1);
                    sub.add(upSub.get(j - 1) + upSub.get(j));
                }
            }
            list.add(sub);
        }
        return list;
    }
}

//我的答案
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        int[] temp = new int[numRows];
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 1; i <= numRows; i ++) {
            if (i == 1) {
                List<Integer> first = new ArrayList<Integer>();
                first.add(0, 1);
                result.add(first);
                temp[0] = 1;
            } else {
                List<Integer> other = new ArrayList<Integer>();
                for (int j = 0; j < i; j ++) {                   
                    if (j == 0 || j == i - 1) {
                        other.add(j, 1);
                    } else {
                        int tempSum = temp[j] + temp[j - 1];
                        other.add(j, tempSum);
                    }
                }
                for (int j = 0; j < i; j ++) {
                    temp[j] = other.get(j);
                }
                result.add(other);
            }           
        }
        return result;
    }
}

/******************************************************************/
/*
Tips：
1、List嵌套问题，List of List
如：
List<List<Integer>>

即List的内容是List的类型，直接使用List<List<Integer>> list = new List<List<Integer>>()是错的，
因为List是接口，不能实例化
(Cannot instantiate the type List<List<Integer>>)。

但如果使用 
 List<List<Integer>> list = new LinkedList<LinkedList<Integer>>(); 
又会报错（cannot convert from LinkedList<LinkedList<Integer>> to List<List<Integer>>），

正确的做法是修改成：
List<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
或
List<List<Integer>> list = new LinkedList<List<Integer>>();
这样才可以，也就是说，泛型的类型参数必须相同。

下面这种处理

ArrayList<ArrayList<String>> list= new ArrayList<ArrayList<String>>();
或
LinkedList<LinkedList<String>> list = new LinkedList<LinkedList<String>>();
也是可以的，这样就没有用 接口类 引用 实现类 了。

其他list的用法可以参见
https://www.cnblogs.com/dya-blog/p/11316508.html
*/