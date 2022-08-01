package cn.nolaurence.good.sw;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: nolaurence
 * @Description: CheckInclusion：leetcode 567
 * @Date: 2022/7/6
 */
public class CheckInclusion {
    public Boolean checkInclusion(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return false;
        }
        /*判断s中是否存在t的排列*/
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;

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
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaooo";
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion(s2, s1));
    }
}
