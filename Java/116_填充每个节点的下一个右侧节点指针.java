// 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }

// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
// 初始状态下，所有 next 指针都被设置为 NULL。

// 提示：
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

// 层序遍历
// O(n)空间复杂度不符合要求

class Solution {
    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                Node k = queue.poll();
                if(i < size)
                    k.next = queue.peek();
                if(k.left != null) queue.add(k.left);
                if(k.right != null) queue.add(k.right);
            }
        }
        return root;
    }
}

// O(1)空间复杂度
// 思路：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/

// 递归

class Solution {
    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        dfs(root);
        return root;
    }
    public void dfs(Node root){
        if(root == null)
            return;
        Node left = root.left;
        Node right = root.right;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}

// 层序迭代

class Solution {
	  public Node connect(Node root) {
		    if(root==null) {
			  return root;
		    }
		    Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点
        //或所有叶子节点都出串联完后循环就退出了
        while(pre.left!=null) {
            Node tmp = pre;
            while(tmp!=null) {
                //将tmp的左右节点都串联起来
                //注:外层循环已经判断了当前节点的left不为空
                tmp.left.next = tmp.right;
                //下一个不为空说明上一层已经帮我们完成串联了
                if(tmp.next!=null) {
                  tmp.right.next = tmp.next.left;
                }
                //继续右边遍历
                tmp = tmp.next;
			      }
        //从下一层的最左边开始遍历
        pre = pre.left;
		    }
		    return root;
	  }
}
