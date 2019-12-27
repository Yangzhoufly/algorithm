package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22括号生成 {

    public static  List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        String temp = "";
        String all = "";
        for (int i = 0; i < n; i++) {
            all += "()";
        }
        System.out.println(all);

        List<Integer> choosedI = new ArrayList<>();
        traceBack(res, temp, n, all, 0, choosedI);
        return res;

    }

    public static void traceBack(List<String> res, String temp, int n, String all, int index, List<Integer> choosedI) {
        if (temp.length() == n*2 && !res.contains(temp)  && valid(temp)) {
            res.add(new String(temp));
            return;
        }
        for (int i = 0; i < all.length(); i++) {
            if (!choosedI.contains(i)) {
                temp += all.substring(i, i + 1);
                choosedI.add(i);
                traceBack(res, temp, n, all, i + 1, choosedI);
                temp = temp.substring(0, temp.length() - 1);
                choosedI.remove(new Integer(i));
            }
        }
    }

    public static boolean valid(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        System.out.println("   :"+str);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {

        System.out.println(generateParenthesis(2));

    }
}
