// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

// 参考以下这颗二叉搜索树：

//      5
//     / \
//    2   6
//   / \
//  1   3

// 示例 ：

// 输入: [1,3,2,6,5]
// 输出: true

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length-1);
    }
    private boolean helper(int[] postorder, int i, int j){
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j])
            p++;
        int m = p;
        while(postorder[p] > postorder[j])
            p++;
        return p == j && helper(postorder, i, m-1) && helper(postorder, m, j-1);
    }
}
