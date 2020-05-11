// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

// B是A的子结构， 即 A中有出现和B相同的结构和节点值。

// 例如:
// 给定的树 A:

//      3
//     / \
//    4   5
//   / \
//  1   2
// 给定的树 B：

//    4 
//   /
//  1
// 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

// 解题思路：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/

// 判断树 A 中当前以 n_A 为根节点的子树 是否包含树 B，也就是helper(A, B)；若不包含，则判断其左子树或右子树是否包含

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right,B);
    }

    public boolean helper(TreeNode a, TreeNode b){
        if(b == null) return true;
        if(a == null) return false;
        if(a.val == b.val){
            return helper(a.left, b.left) && helper(a.right, b.right);
        }else{
            return false;
        }
    }
}
