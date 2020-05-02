// 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

// 示例 1:

// 输入: [[0, 30],[5, 10],[15, 20]]
// 输出: 2

// 解题思路：https://blog.csdn.net/yinianxx/article/details/105785284

// 方法：用优先级队列实现最小堆

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        // 将区间按照各数组开始时间升序排序
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        // 建立优先级队列，按照各数组结束时间升序排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        queue.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            // 队首元素为最早会议结束时间(start)，如果另一场会议的开始时间早于start，则没有空闲会议室，需要新开一间；否则，弹出队首元素
            if(intervals[i][0] >= queue.peek())
                queue.poll();
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
}
