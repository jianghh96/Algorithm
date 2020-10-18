// 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 返回锯齿形层次遍历如下：

// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// 遍历第二层的节点的顺序是从左到右，而输出第二层节点的顺序是从右到左，这正好满足栈思想，所有用栈来第二层所有节点。

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode cur = null;
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    cur = stack1.pop();
                    list.add(cur.val);
                    if(cur.left != null) stack2.push(cur.left);
                    if(cur.right != null) stack2.push(cur.right);
                }
                res.add(list);
            }else{
                while(!stack2.isEmpty()){
                    cur = stack2.pop();
                    list.add(cur.val);
                    // 注意从右往左，先right后left
                    if(cur.right != null) stack1.push(cur.right);
                    if(cur.left != null) stack1.push(cur.left);
                }
                res.add(list);
            }
        }
        return res;
    }
}
