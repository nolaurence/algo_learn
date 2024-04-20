package cn.nolaurence.labuladong.sw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: nolaurence
 * @Description: leetcode 438
 * @Date: 2022/7/11
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        List<Integer> result = new ArrayList<>();  // 记录结果

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入result
                if (valid == need.size()) {
                    result.add(left);
                }

                char d = s.charAt(left);
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        FindAnagrams solution = new FindAnagrams();
        System.out.println(solution.findAnagrams(s, p));
    }
}
