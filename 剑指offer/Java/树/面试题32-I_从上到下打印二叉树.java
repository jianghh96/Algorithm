// 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

// 例如:

// 给定二叉树: [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 返回：

// [3,9,20,15,7]

class Solution {
    public int[] levelOrder(TreeNode root) {
        // 层序遍历
        if(root == null) return new int[0];
        List<TreeNode> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            //for(int i = 0; i < list.size(); i++){
                TreeNode p = list.remove(0);
                res.add(p.val);
                if(p.left != null) list.add(p.left);
                if(p.right != null) list.add(p.right);
           //}
        }
        int[] nums = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            nums[i] = res.get(i);
        }
        return nums;
    }
}
