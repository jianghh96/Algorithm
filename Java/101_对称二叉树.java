// 给定一个二叉树，检查它是否是镜像对称的。

// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3

// 方法1：递归
// 左子树的左子树等于右子树的右子树，左子树的右子树等于右子树的左子树

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }else if(r1 == null || r2 == null){
            return false;
        }else{
            if(r1.val == r2.val)
                return compare(r1.left, r2.right) && compare(r1.right, r2.left);
            else
                return false;
        }
    }
}

