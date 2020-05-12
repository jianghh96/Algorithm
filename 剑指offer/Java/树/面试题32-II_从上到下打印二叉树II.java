// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

// 例如:

// 给定二叉树: [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 返回其层次遍历结果：

// [
//   [3],
//   [9,20],
//   [15,7]
// ]

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            // 注意！删除队首元素后队列长度会发生变化！
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode p = queue.poll();
                list.add(p.val);
                if(p.left != null) queue.add(p.left);
                if(p.right != null) queue.add(p.right);
            }
            res.add(list);
        }
        return res;
    }
}
