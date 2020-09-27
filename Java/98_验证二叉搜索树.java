// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

// 假设一个二叉搜索树具有如下特征：

// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。

// 方法1：中序遍历
// 二叉搜索树必然想到中序遍历！！！用栈来写！！！

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
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left))
            return false;
        if(root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // 中序遍历！
        Stack<TreeNode> stack = new Stack<>();
        // 注意这里！大小写意义和用法！
        double pre = - Double.MAX_VALUE;
        // 
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= pre) return false;
            // 注意更新pre值！
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}

// 递归
// 首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程。

class Solution {
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    if (! helper(node.right, val, upper)) return false;
    if (! helper(node.left, lower, val)) return false;
    return true;
  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }
}
