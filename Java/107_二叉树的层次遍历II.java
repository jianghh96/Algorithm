// 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

// 例如：

// 给定二叉树 [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 返回其自底向上的层次遍历为：

// [
//   [15,7],
//   [9,20],
//   [3]
// ]

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                l.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(l);
        }
        // if(list.size() == 1) return list;
        // List<List<Integer>> res = new ArrayList<>();
        // for(int i = list.size()-1; i >= 0; i--)
        //     res.add(list.get(i));
        Collections.reverse(list);
        return list;
    }
}
