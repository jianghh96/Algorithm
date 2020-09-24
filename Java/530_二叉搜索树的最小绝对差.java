// 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

// 示例：

// 输入：

//    1
//     \
//      3
//     /
//    2

// 输出：
// 1

// 解释：
// 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。

class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int left = 0, right = 1;
        int num = list.get(right)-list.get(left);
        while(right < list.size()){
            num = Math.min(num, list.get(right)-list.get(left));
            left++;
            right++;
        }
        return num;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
