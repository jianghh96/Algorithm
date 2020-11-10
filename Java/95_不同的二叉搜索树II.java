// 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

// 示例：

// 输入：3
// 输出：

// [
//   [1,null,3,2],
//   [3,2,null,1],
//   [3,1,null,null,2],
//   [2,1,3],
//   [1,null,2,null,3]
// ]

// 解释：
// 以上的输出对应以下 5 种不同结构的二叉搜索树：

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
 
// 提示：
// 0 <= n <= 8

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n < 1) return res;
        return getTrees(1, n);
    }
    public List<TreeNode> getTrees(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            // 需.add(null)!
            res.add(null);
            return res;
        }
        if(start == end){
            res.add(new TreeNode(start));
            return res;
        }
        // 每个数都能作为根节点
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = getTrees(start, i-1);
            List<TreeNode> rightTrees = getTrees(i+1, end);
            for(TreeNode leftTree : leftTrees){
                for(TreeNode rightTree : rightTrees){
                    // 根节点每次都需新建，不能放在外层
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
