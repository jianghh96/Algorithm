// 给定一个二叉树，在树的最后一行找到最左边的值。

// 示例:

// 输入:

//         1
//        / \
//       2   3
//      /   / \
//     4   5   6
//        /
//       7

// 输出:
// 7

// 层序遍历 BFS

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.right != null){
                queue.add(node.right);
                res = node.right.val;
            }
            if(node.left != null){
                queue.add(node.left);
                res = node.left.val;
            }
        }
        return res;
    }
}

// 递归

class Solution {
    int res;
    int maxdepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode root, int depth){  // depth 指上一层深度
        if(++depth > maxdepth){
            maxdepth = depth;
            res = root.val;
        }
        if(root.left != null)
            helper(root.left, depth);
        if(root.right != null)
            helper(root.right, depth);
    }
}
