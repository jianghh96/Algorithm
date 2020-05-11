// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }else if(r1 == null || r2 == null){
            return false;
        }else{
            if(r1.val == r2.val){
                return symmetric(r1.left, r2.right) && symmetric(r1.right, r2.left);
            }else{
                return false;
            }
        }
    }
}

