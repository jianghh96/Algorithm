// 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

// 说明：
// 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

// 示例 :

// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 1

// 二叉查找树中序遍历有序

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(--k == 0) break;
            cur = cur.right;
        }
        return cur.val;
    }
}


class Solution {
    int res, k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        if(k == 0)
            return;
        if(k == 1)
            res = root.val;
        k--;
        dfs(root.right);
    }
}
