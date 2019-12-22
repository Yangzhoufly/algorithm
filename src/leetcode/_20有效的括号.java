package leetcode;

import java.util.Stack;

public class _20有效的括号 {

    public static  boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0){
            return false;
        }
        if(s.length() == 0){
            return true;
        }

        Stack<Character> stack =new Stack<>();

        String left="({[";
        String right=")}]";

        for(int i=0;i<s.length();i++){
            //空的
            if(stack.isEmpty()==true){
                if(left.contains(s.substring(i,i+1))){
                    stack.push(s.charAt(i));
                }else{
                    return false;
                }
            }
            //非空
            else if(left.contains(s.substring(i,i+1))){
                stack.push(s.charAt(i));
            }else{
                if(left.indexOf(stack.pop())!=right.indexOf(s.charAt(i))){
                   return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {


        String s="[]";
        System.out.println(isValid(s));

    }
}
