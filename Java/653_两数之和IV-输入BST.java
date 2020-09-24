// 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

// 案例 1:

// 输入: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 9

// 输出: True

// 中序遍历 + 双指针

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int left = 0, right = list.size()-1;
        while(left < right){
            int sum = list.get(left) + list.get(right);
            if(sum == k)
                return true;
            else if(sum < k)
                left++;
            else
                right--;
        }
        return false;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}

// HashSet递归

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if(root == null) return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
