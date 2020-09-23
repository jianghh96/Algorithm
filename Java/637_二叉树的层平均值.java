// 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

// 示例 1：

// 输入：
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 输出：[3, 14.5, 11]
// 解释：
// 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。

// BFS

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            double sum = 0;
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll(); //queue.remove()也行;
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(sum / len);
        }
        return res;
    }
}
