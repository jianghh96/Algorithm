// 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

// 说明: 叶子节点是指没有子节点的节点。

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

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> list = new ArrayList<>();
        backtracking(root, sum, res, list);
        return res;
    }
    public void backtracking(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list){
        if(root == null)
            return;
        // 1.root==null再添加到res会有重复
        // 2.res.add(new ArrayList(list))
        if(root.left == null && root.right == null && root.val == sum){
            list.add(root.val);
            res.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        backtracking(root.left, sum-root.val, res, list);
        backtracking(root.right, sum-root.val, res, list);
        list.remove(list.size()-1);
    }
}
