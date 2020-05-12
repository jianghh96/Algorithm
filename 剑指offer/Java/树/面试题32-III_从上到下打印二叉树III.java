// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

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
//   [20,9],
//   [15,7]
// ]

// 双端队列

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // 双端队列
            // 注意这里Deque不对应List<Integer>，故用LinkedList<Integer>
            LinkedList<Integer> deque = new LinkedList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode p = queue.poll();
                if(res.size() % 2 == 0)
                    deque.addLast(p.val);
                else
                    deque.addFirst(p.val);
                if(p.left != null) queue.add(p.left);
                if(p.right != null) queue.add(p.right);
            }
            res.add(deque);
        }
        return res;
    }
}

// 层序遍历 + 倒序

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            // 倒序
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}
