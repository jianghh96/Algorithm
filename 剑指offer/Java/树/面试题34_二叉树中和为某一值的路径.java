// 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

// 示例:

// 给定如下二叉树，以及目标和 sum = 22，

//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1

// 返回:

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

// 回溯

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return res;
        helper(root, sum, res, list);
        return res;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == root.val)
            // 注意这里不是直接添加list，而是将list的元素复制到一个新的ArrayList！
            res.add(new ArrayList<>(list));
        helper(root.left, sum - root.val, res, list);
        helper(root.right, sum - root.val, res, list);
        // 回溯一下！
        list.remove(list.size() - 1);
    }
}
