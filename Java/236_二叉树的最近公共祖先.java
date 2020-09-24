// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

// 解题思路：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetcod/

// 方法一：递归

// 从根节点开始遍历树。
// 如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。
// 如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
// 如果在遍历的任何点上，left、right 或者 mid 三个标记中的任意两个变为 true，这意味着我们找到了节点 p 和 q 的最近公共祖先。

class Solution {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        boolean mid = (node == p || node == q);
        if(mid ? (left || right) : left && right)
            res = node;
        return left || right || mid;
    }
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 注意边界条件
        if(root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }
}
