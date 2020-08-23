package com.hbq.aop.algorithm.week02;

public class ValidAnagram {

    /**
     * 1、使用26个长度数组表示字母出现的次数
     * 2、两次遍历，第一次算第1个字符串字母，第二次算第2个字符串并判断《0
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }

        int[] tArr = new int[26];

        int len = s.length();
        for (int i = 0; i < len; i++) {
            tArr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (--tArr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
