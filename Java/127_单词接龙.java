// 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。

// 说明:

// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

// 示例 1:

// 输入:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// 输出: 5

// 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//       返回它的长度 5。

// 示例 2:

// 输入:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]

// 输出: 0

// 解释: endWord "cog" 不在字典中，所以无法进行转换。

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while(!queue.isEmpty()){
            // 队列弹出添加长度会发生变化
            int queueLength = queue.size();
            for(int k = 0; k < queueLength; k++){
                // 依次遍历当前队列中的单词
                String curWord = queue.poll();
                char[] curChar = curWord.toCharArray();
                for(int i = 0; i < endWord.length(); i++){
                    // 先保存，然后恢复
                    char originChar = curChar[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == originChar)
                            continue;
                        curChar[i] = c;
                        String nextWord = String.valueOf(curChar);
                        if(wordSet.contains(nextWord)){
                            if(nextWord.equals(endWord))
                                return step+1;
                            if(!visited.contains(nextWord)){
                                // 添加到队列以后，必须马上标记为已经访问
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    // 恢复
                    curChar[i] = originChar;
                }
            }
            step++;
        }
        return 0;
    }
}
