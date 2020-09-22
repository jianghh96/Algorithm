// 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

// 示例 1:

// 输入: 
//     2
//    / \
//   2   5
//      / \
//     5   7

// 输出: 5
// 说明: 最小的值是 2 ，第二小的值是 5 。

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        // 最小值在根节点
        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;
        int left = root.left.val;
        int right = root.right.val;
        if(left == root.val) left = findSecondMinimumValue(root.left);
        if(right == root.val) right = findSecondMinimumValue(root.right);
        if(left != -1 && right != -1)
            return Math.min(left, right);
        else if(left != -1)
            return left;
        else
            return right;
    }
}
