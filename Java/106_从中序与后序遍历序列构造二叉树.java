// 根据一棵树的中序遍历与后序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 例如，给出

// 中序遍历 inorder = [9,3,15,20,7]
// 后序遍历 postorder = [9,15,7,20,3]

// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 递归 O(n^2)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        int index = 0, len = inorder.length;
        while(inorder[index] != postorder[len-1])
            index++;
        TreeNode root = new TreeNode(inorder[index]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index+1, len), Arrays.copyOfRange(postorder, index, len-1));
        return root;
    }
}

// 哈希表 O(n)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }
    public TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end, HashMap<Integer, Integer> map){
        if(i_start == i_end) return null;
        int root_val = postorder[p_end-1];
        int index = map.get(root_val);
        int leftNum = index - i_start;
        TreeNode root = new TreeNode(root_val); 
        root.left = helper(inorder, i_start, index, postorder, p_start, p_start + leftNum, map);
        root.right = helper(inorder, index+1, i_end, postorder, p_start + leftNum, p_end-1, map);
        return root;
    }
}
