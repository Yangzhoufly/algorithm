package leetcode._01回溯法;

import java.util.ArrayList;
import java.util.List;

public class _17电话号码的字母组合 {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<String[]> numStr = parseStr(digits);
        String temp = "";
        traceBack(res, "", numStr, 0);

        return res;

    }

    public static void traceBack(List<String> res, String temp, List<String[]> numStr, int ii) {
        if (temp.length() == numStr.size()) {
            res.add(new String(temp));
            return;
        }
        for (int i = ii; i < numStr.size(); i++) {
            for (int j = 0; j < numStr.get(i).length; j++) {
                temp += numStr.get(i)[j];
                traceBack(res, temp, numStr, i + 1);
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    public static List<String[]> parseStr(String digits) {
        String[] split = digits.split("");
        List<String[]> numStr = new ArrayList<>();
        for (String s : split) {
            switch (s) {
                case "2":
                    numStr.add("abc".split(""));
                    break;
                case "3":
                    numStr.add("def".split(""));
                    break;
                case "4":
                    numStr.add("ghi".split(""));
                    break;
                case "5":
                    numStr.add("jkl".split(""));
                    break;
                case "6":
                    numStr.add("mno".split(""));
                    break;
                case "7":
                    numStr.add("pqrs".split(""));
                    break;
                case "8":
                    numStr.add("tuv".split(""));
                    break;
                case "9":
                    numStr.add("wxyz".split(""));
                    break;
            }
        }
        return numStr;
    }

    public static void main(String[] args) {
        String digits="123";
        System.out.println(letterCombinations("123"));

    }
}
