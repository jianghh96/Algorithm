// 给定一个二叉树，返回所有从根节点到叶子节点的路径。

// 说明: 叶子节点是指没有子节点的节点。

// 示例:

// 输入:

//    1
//  /   \
// 2     3
//  \
//   5

// 输出: ["1->2->5", "1->3"]

// 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

// DFS + 递归

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        String path = "";
        dfs(root, path, res);
        return res;
    }
    public void dfs(TreeNode root, String path, List<String> res){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            res.add(path + root.val);
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }
}

// 递归

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        if(root.left == null && root.right == null){
            res.add(root.val + "");
            return res;
        }
        for(String s : binaryTreePaths(root.left))
            res.add(root.val + "->" + s);
        for(String s : binaryTreePaths(root.right))
            res.add(root.val + "->" + s);
        return res;
    }
}
