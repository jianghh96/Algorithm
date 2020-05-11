// 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pre = preorder.length;
        int in = inorder.length;
        if(pre == 0 || in == 0) return null;
        int k = 0;
        for(int i = 0; i < in; i++){
            if(inorder[i] == preorder[0]){
                k = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, k+1), Arrays.copyOfRange(inorder, 0, k));
        root.right = buildTree(Arrays.copyOfRange(preorder, k+1, pre), Arrays.copyOfRange(inorder, k+1, in));
        return root;
    }
}
