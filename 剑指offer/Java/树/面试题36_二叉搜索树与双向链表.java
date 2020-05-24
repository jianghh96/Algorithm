// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

// 解题思路：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/

class Solution {
    Node pre = null, head = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        midOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    public void midOrder(Node root){
        if(root == null) return;
        midOrder(root.left);
        root.left = pre;
        // 注意这里
        if(pre != null)
            pre.right = root;
        else
            head = root;
        pre = root;
        midOrder(root.right);
    }
}
