// 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

// 示例 :
// 给定二叉树

//           1
//          / \
//         2   3
//        / \     
//       4   5    
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

// 注意：两结点之间的路径长度是以它们之间边的数目表示。

class Solution {
    int maxlen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxlen;
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        maxlen = Math.max(left+right, maxlen); //将每个节点最大直径(左子树深度层数+右子树深度)当前最大值比较并取大者
        return Math.max(left, right) + 1; //返回节点深度
    }
}
