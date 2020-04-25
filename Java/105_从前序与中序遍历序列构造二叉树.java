// 根据一棵树的前序遍历与中序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 方法：递归

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int np = preorder.length;
        int ni = inorder.length;
        if(np == 0 || ni == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for(int i = 0; i < np; i++){
            if(inorder[i] == preorder[0]){
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, np), Arrays.copyOfRange(inorder, index+1, ni));
        return root;
    }
}

// 用一个HashMap把中序遍历数组的每个元素的值和下标存起来

public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
}

private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
                                 HashMap<Integer, Integer> map) {
    if (p_start == p_end) {
        return null;
    }
    int root_val = preorder[p_start];
    TreeNode root = new TreeNode(root_val);
    int i_root_index = map.get(root_val);
    int leftNum = i_root_index - i_start;
    root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
    root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
    return root;
}
