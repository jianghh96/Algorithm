// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

// 示例 1:

// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));
        for(int key : map.keySet()){
            // 这一步不要想错了！！！
            heap.add(key);
            if(heap.size() > k) 
                heap.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}
