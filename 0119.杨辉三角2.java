//思路：
//这道题考察的仍然是对list的应用，这里我的思路是使用两个list即可。
//要注意的是，题目要求的给定索引，而不是行数。从0开始。
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> upK = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        for (int i = 0; i <= rowIndex + 1; i ++){
            for (int j = 0; j < i; j ++){
                if (j == 0 || j == i - 1) {
                    k.add(1);
                } else {
                    k.add(upK.get(j) + upK.get(j - 1));
                }               
            }
            upK.clear();
            upK.addAll(k);
            k.clear();
        }
        return upK;
    }
}

//上面的思路用的是两个list。这样代码不够简洁。其实还可以用一个list即可。
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i ++) {
            result.add(1);  //直接在后面补充一个1，作为末尾位
            for (int j = i - 1; j > 0; j --){  //从后往前
                result.set(j, (result.get(j) + result.get(j - 1)));
            }   
        }
        return result;
    }
}

/*
注意：使用一个list的时候，需要从后往前，而不是从前往后，不然会改变前面的数值。
*/
