// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

// 方法1：迭代

// 列表迭代

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while(!nodeList.isEmpty()){
            List<Integer> value = new ArrayList<>();
            // 注意这里：先计算长度！不能放在for循环括号条件里！
            int len = nodeList.size();
            for(int i = 0; i < len; i++){
                TreeNode node = nodeList.remove(0);
                value.add(node.val);
                if(node.left != null) nodeList.add(node.left);
                if(node.right != null) nodeList.add(node.right);
            }
            res.add(value);
        }
        return res;
    }
}

// 队列迭代

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        // 注意队列用法！
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> value = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                value.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(value);
        }
        return res;
    }  
}
