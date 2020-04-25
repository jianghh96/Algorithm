// 给定一个二叉树，找出其最大深度。

// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

// 说明: 叶子节点是指没有子节点的节点。

// 方法1：迭代

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            res++;
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}

// 方法2：递归

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
