// 输入一个字符串，打印出该字符串中字符的所有排列。

// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

// 示例:

// 输入：s = "abc"
// 输出：["abc","acb","bac","bca","cab","cba"]

// 解题思路：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/

public class Exam38_permutation {
    List<String> list = new ArrayList<>();
    //为了让递归函数添加结果方便，定义到函数之外，这样无需带到递归函数的参数列表中
    char[] c;
    //同；但是其赋值依赖c，定义声明分开
    public String[] permutation(String s) {
        c = s.toCharArray();
        //从第一层开始递归
        dfs(0);
        return list.toArray(new String[list.size()]);
        //将字符串数组ArrayList转化为String类型数组
    }

    private void dfs(int x) {
        //当递归函数到达第三层，就返回，因为此时第二第三个位置已经发生了交换
        if (x == c.length - 1) {
            list.add(String.valueOf(c));//将字符数组转换为字符串
            return;
        }
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        //这里就很巧妙了,第一层可以是a,b,c那么就有三种情况，这里i = x,正巧dfs(0)，正好i = 0开始
        // 当第二层只有两种情况，dfs(1）i = 1开始
        for (int i = x; i < c.length; i++){
            //发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            //交换元素，这里很是巧妙，当在第二层dfs(1),x = 1,那么i = 1或者 2， 要不是交换1和1，要不交换1和2
            swap(i,x);
            //进入下一层递归
            dfs(x + 1);
            //返回时交换回来，这样保证到达第1层的时候，一直都是abc。这里捋顺一下，开始一直都是abc，那么第一位置总共就3个位置
            //分别是a与a交换，这个就相当于 x = 0, i = 0;
            //     a与b交换            x = 0, i = 1;
            //     a与c交换            x = 0, i = 2;
            //就相当于上图中开始的三条路径
            //第一个元素固定后，每个引出两条路径,
            //     b与b交换            x = 1, i = 1;
            //     b与c交换            x = 1, i = 2;
            //所以，结合上图，在每条路径上标注上i的值，就会非常容易好理解了
            swap(i,x);
        }
    }

    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}
