// 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

// 示例 1:

// 输入:
// "tree"

// 输出:
// "eert"

// 解释:
// 'e'出现两次，'r'和't'都只出现一次。
// 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

// 示例 2:

// 输入:
// "cccaaa"

// 输出:
// "cccaaa"

// 解释:
// 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
// 注意"cacaca"是不正确的，因为相同的字母必须放在一起。

// 示例 3:

// 输入:
// "Aabb"

// 输出:
// "bbAa"

// 解释:
// 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
// 注意'A'和'a'被认为是两种不同的字符。

// 堆排序

class Solution {
    public String frequencySort(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : charArray)
            map.put(c, map.getOrDefault(c, 0)+1);
        PriorityQueue<Character> heap = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for(char c : map.keySet())
            heap.add(c);
        StringBuilder res = new StringBuilder();
        while(!heap.isEmpty()){
            char c = heap.poll();
            for(int i = 0; i < map.get(c); i++)
                res.append(c);
        }
        return res.toString();
    }
}

// 桶排序

class Solution {
    public String frequencySort(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : charArray)
            map.put(c, map.getOrDefault(c, 0)+1);
        
        // 装桶
        List<Character>[] list = new ArrayList[s.length()+1];
        for(char c : map.keySet()){
            int i = map.get(c);
            if(list[i] == null)
                list[i] = new ArrayList<>();
            list[i].add(c);
        }

        // 输出
        StringBuilder res = new StringBuilder();
        for(int i = s.length(); i >= 0; i--){
            if(list[i] == null)
                continue;
            for(char c : list[i]){
                for(int j = 0; j < i; j++)
                    res.append(c);
            }
        }
        return res.toString();
    }
}
