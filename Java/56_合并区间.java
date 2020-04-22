// 给出一个区间的集合，请合并所有重叠的区间。

// 示例 1:

// 输入: [[1,3],[2,6],[8,10],[15,18]]
// 输出: [[1,6],[8,10],[15,18]]
// 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

// 贪心算法

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n < 1) return intervals;

        // 先按照区间起始位置排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i < n; i++){
            int[] curInterval = intervals[i];
            int[] last = res.get(res.size() - 1);

            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            if(curInterval[0] > last[1]){
                res.add(curInterval);
            }else{
                last[1] = Math.max(last[1], curInterval[1]);
            }
        }

        // 需要指定toArray()里的参数，否则默认为obj对象
        return res.toArray(new int[res.size()][]);
    }
}
