// 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

// 注意：
// 总人数少于1100人。

// 示例

// 输入:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

// 输出:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

// 解题思路：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        List<int[]> list = new LinkedList<>();
        for(int[] p : people)
            list.add(p[1], p);
        return list.toArray(people);
    }
}
