// 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

// 示例 1：

// 输入：arr = [3,2,1], k = 2
// 输出：[1,2] 或者 [2,1]

// java自带优先级队列

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0)
            return new int[0];
        // 默认是小根堆，实现大根堆需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for(int num : arr){
            if(pq.size() < k){
                pq.add(num);
            }else{
                if(num < pq.peek()){
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num : pq){
            res[idx] = num;
            idx++;
        }
        return res;
    }
}

// 手动建堆

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0)
            return new int[0];
        int[] heap = Arrays.copyOfRange(arr, 0, k);
        buildHeap(heap);
        for(int i = k; i < arr.length; i++){
            if(arr[i] < heap[0]){
                heap[0] = arr[i];
                //swap(heap, 0, k-1);
                buildHeap(heap);
            }
        }
        return heap;
    }
    public void buildHeap(int[] heap){
        int len = heap.length;
        for(int i = len / 2 - 1; i >= 0; i--){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < len && heap[left] > heap[i]){
                swap(heap, left, i);
            }
            if(right < len && heap[right] > heap[i]){
                swap(heap, right, i);
            }
        }
    }
    public void swap(int[] heap, int a, int b){
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
