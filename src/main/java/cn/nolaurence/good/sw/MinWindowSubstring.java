package cn.nolaurence.good.sw;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;

/**
 * @Author: nolaurence
 * @Description: Demo
 * @Date: 2022/7/4
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

//        Map<Character, Integer> need = new HashMap<>();
//        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // Left and Right pointer
        int left = 0, right = 0;
        int valid = 0;

        // 记录最小覆盖字串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // while (need.size().equals(valid)) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
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

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public String minWindowFixed(String s, String t) {
        int[] counts = new int[100];

        // 构建need
        for (char c : t.toCharArray()) {
            counts[c - 'A']++;
        }
        char[] cs = s.toCharArray();

        int num = t.length(), pre = 0, ans = cs.length + 1, pos = 0, len = cs.length;
//        int num = t.length(), pre = 0, ans = cs.length + 1, pos = 0, len = cs.length;

        for (int i = 0; i < len; ++i) {
            if (--counts[cs[i] - 'A'] >= 0) {
                num--;
            }

            while (pre < len && counts[cs[pre] - 'A'] < 0) {
                counts[cs[pre++] - 'A']++;
            }
            if (num == 0 && i - pre + 1 < ans) {
                ans = i - pre + 1;
                pos = pre;
            }
        }

        return ans == cs.length + 1? "" : s.substring(pos, pos + ans);
    }

    public static String readFile2String(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
//        String testS = "ADOBECODEBANC", testT = "ABC";
        String filenameS = "src/main/resources/s.txt";
        String filenameT = "src/main/resources/t.txt";
        String filenameTC = "src/main/resources/tc.txt";
        String badS = readFile2String(filenameS);
        String badT = readFile2String(filenameT);
        String badTC = readFile2String(filenameTC);

//        System.out.println(badS);
//        System.out.println(badT);
        String result = minWindowSubstring.minWindow(badS, badT);
        System.out.println(result);
        System.out.println(result.equals(badTC));
    }
}
