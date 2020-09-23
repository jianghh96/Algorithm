// 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
// 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

// 示例 :

// 输入: 
//     3
//    / \
//   0   4
//    \
//     2
//    /
//   1

//   L = 1
//   R = 3

// 输出: 
//       3
//      / 
//    2   
//   /
//  1

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;
        if(root.val < low) return trimBST(root.right, low, high);
        if(root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, root.val);
        root.right = trimBST(root.right, root.val, high);
        return root;
    }
}
