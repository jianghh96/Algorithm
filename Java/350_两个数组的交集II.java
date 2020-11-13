// 给定两个数组，编写一个函数来计算它们的交集。

// 示例 1：

// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2,2]

// 示例 2:

// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[4,9]
 
// 说明：
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。

// 进阶：
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

// 哈希表

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int num1 : nums1)
            map1.put(num1, map1.getOrDefault(num1, 0)+1);
        int count = 0;
        for(int num2 : nums2){
            if(map1.containsKey(num2) && map2.getOrDefault(num2, 0) < map1.get(num2)){
                map2.put(num2, map2.getOrDefault(num2, 0)+1);
                count++;
            }
        }
        int[] res = new int[count];
        int index = 0;
        for(int num : map2.keySet()){
            for(int i = 0; i < map2.get(num); i++)
                res[index++] = num;
        }
        return res;
    }
}

// 双指针

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int num : list)
            res[index++] = num;
        return res;
    }
}
