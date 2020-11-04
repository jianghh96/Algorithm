// 给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数。

// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

// 示例 1：

// 输入：nums = [10,2]
// 输出："210"

// 示例 2：

// 输入：nums = [3,30,34,5,9]
// 输出："9534330"

// 示例 3：

// 输入：nums = [1]
// 输出："1"

// 示例 4：

// 输入：nums = [10]
// 输出："10"
 
// 提示：
// 1 <= nums.length <= 10^0
// 0 <= nums[i] <= 10^9

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] sArray = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            sArray[i] = String.valueOf(nums[i]);
        Arrays.sort(sArray, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        if(sArray[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for(String s : sArray)
            res.append(s);
        return res.toString();
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] sArray = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            sArray[i] = String.valueOf(nums[i]);
        Arrays.sort(sArray, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        if(sArray[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for(String s : sArray)
            res.append(s);
        return res.toString();
    }
}
