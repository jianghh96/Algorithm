// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。

class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        boolean sign = false, point = false, has_e = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                // e只能存在一个且不在最后一位
                if(has_e) return false;
                has_e = true;
                if(i == s.length()-1) return false;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                // +-可存在，但第二次前面必须是e
                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
                    return false;
                point = true;
            }else if(s.charAt(i) == '.'){
                // .只能存在一次且不能存在e
                if(point || has_e) return false;
                point = true;
            }else{
                if(s.charAt(i) < '0' || s.charAt(i) > '9')
                    return false;
            }
        }
        return true;
    }
}


class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        boolean haveNum = false;
        boolean haveBot = false;
        boolean haveE = false;
        char[] charArr = s.trim().toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] >= '0' && charArr[i] <= '9')
                haveNum = true;
            else if(charArr[i] == '.'){
                if(haveBot || haveE)
                    return false;
                haveBot = true;
            }else if(charArr[i] == 'e' || charArr[i] == 'E'){
                if(!haveNum || haveE)
                    return false;
                haveE = true;
                haveNum = false;
            }else if(charArr[i] == '+' || charArr[i] == '-'){
                if(i != 0 && charArr[i-1] != 'e' && charArr[i-1] != 'E')
                    return false;
            }else
                return false;
        }
        return haveNum;
    }
}
