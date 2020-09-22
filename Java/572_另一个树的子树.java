// 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

// 示例 :
// 给定的树 s：

//      3
//     / \
//    4   5
//   / \
//  1   2
//     /
//    0

// 给定的树 t：

//    4
//   / \
//  1   2
// 返回 false。

// 关注root和左右子树

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return rootTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean rootTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return rootTree(s.left, t.left) && rootTree(s.right, t.right);
    }
}
