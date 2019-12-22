package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _784字母大小写全排列 {

    public static List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0  ) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        traceBack(res, s, s, 0);

        return res;

    }

    public static void traceBack(List<String> res, String temp, String s, int index) {
        res.add(temp);

        for (int i = index; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);
            if (cur.matches(".*[A-Za-z].*")) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, cur.matches(".*[A-Z].*") ? cur.toLowerCase().charAt(0) : cur.toUpperCase().charAt(0));
                traceBack(res, sb.toString(), sb.toString(), i + 1);
            }
        }

    }


    public static void main(String[] args) {
        String s = "a1b2";

        System.out.println(letterCasePermutation(s));

    }

}
