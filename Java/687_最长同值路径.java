// 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

// 注意：两个节点之间的路径长度由它们之间的边数表示。

// 示例 1:

// 输入:

//               5
//              / \
//             4   5
//            / \   \
//           1   1   5

// 输出:
// 2

class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return res;
    }
    //递归函数：搜寻以node为起点的最长同值路径:要么是以node为起点的左子树，要么是以node为起点的右子树
    public int dfs(TreeNode node){
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftpath = node.left != null && node.val == node.left.val ? left+1 : 0;
        int rightpath = node.right != null && node.val == node.right.val ? right+1 : 0;
        res = Math.max(res, leftpath + rightpath);
        return Math.max(leftpath, rightpath);
    }
}
