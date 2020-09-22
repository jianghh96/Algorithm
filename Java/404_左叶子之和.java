// 计算给定二叉树的所有左叶子之和。

// 示例：

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

// 左叶子->先判断是否为叶子节点

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    // 判断是不是叶子节点
    public boolean isLeaf(TreeNode node){
        if(node == null) return false;
        return node.left == null && node.right == null;
    }
}
