// 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

// 假定 BST 有如下定义：

// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
// 例如：
// 给定 BST [1,null,2,2],

//    1
//     \
//      2
//     /
//    2
// 返回[2].

// 提示：如果众数超过1个，不需考虑输出顺序

// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

class Solution {
    int curCnt = 1;
    int maxCnt = 1;
    TreeNode preNode = null;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] res = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++){
            res[i] = nums.get(i);
        }
        return res;
    }
    public void inOrder(TreeNode node, List<Integer> nums){
        if(node == null) return;
        inOrder(node.left, nums);
        if(preNode != null){
            if(preNode.val == node.val)
                curCnt++;
            else
                curCnt = 1;
        }
        if(curCnt > maxCnt){
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        }else if(curCnt == maxCnt){
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }
}
