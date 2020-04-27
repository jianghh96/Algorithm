// 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

// 示例 2:

// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
// 输出: 4

// 解题思路：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/

// 方法1：堆排序

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = nums.length;
        int[] heap = Arrays.copyOfRange(nums, 0, k);
        build_heap(heap);
        for(int i = k; i < l; i++){
            if(nums[i] > heap[0]){
                heap[0] = nums[i];
                int tmp = heap[0];
                heap[0] = heap[k-1];
                heap[k-1] = tmp;
                build_heap(heap);
            }
        }
        return heap[0];
    }

    public void build_heap(int[] heap){
        int len = heap.length;
        for(int i = len / 2; i >= 0; i--){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < len && heap[left] < heap[i]){
                int tmp1 = heap[left];
                heap[left] = heap[i];
                heap[i] = tmp1;
            }
            if(right < len && heap[right] < heap[i]){
                int tmp2 = heap[right];
                heap[right] = heap[i];
                heap[i] = tmp2;
            }
        }
    }
}

// 方法2：优先级队列由堆实现

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.peek();        
  }
}

