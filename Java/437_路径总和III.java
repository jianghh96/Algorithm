// 给定一个二叉树，它的每个结点都存放着一个整数值。

// 找出路径和等于给定数值的路径总数。

// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

// 示例：

// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

//       10
//      /  \
//     5   -3
//    / \    \
//   3   2   11
//  / \   \
// 3  -2   1

// 返回 3。和等于 8 的路径有:
// 1.  5 -> 3
// 2.  5 -> 2 -> 1
// 3.  -3 -> 11

// 解题思路：https://leetcode-cn.com/problems/path-sum-iii/solution/437lu-jing-zong-he-iii-di-gui-fang-shi-by-ming-zhi/

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int r = countPath(root, sum);
        int rl = pathSum(root.left, sum);
        int rr = pathSum(root.right, sum);
        return r + rl + rr;
    }
    public int countPath(TreeNode root, int sum){
        if(root == null) return 0;
        sum -= root.val;
        int res = sum == 0 ? 1 : 0;
        return res + countPath(root.left, sum) + countPath(root.right, sum);
    }
}
