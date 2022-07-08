package cn.nolaurence.good;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: nolaurence
 * @Description: leetcode 3
 * @Date: 2022/7/8
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                window.put(d, window.getOrDefault(d, 0)-1);
            }
            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
