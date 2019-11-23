package 牛客初级._06贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心策略不用去证明，用对数器验证就好了
 * 给一个字符串数组，返回一个字典序最小的字符串
 */

public class _02字符串拼接字典序最小 {
    public static class MyStringComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b) {
            return (a+b).compareTo(b+a);
        }
    }//定义的比较策略需要有   传递性


    public static String lowestString(String [] strs){
        if(strs == null || strs.length==0){
            return null;
        }
        Arrays.sort(strs,new MyStringComparator());
        String res="";
        for (String str : strs) {
            res+=str;
        }
        return res;
    }

    /**
     *传递性：
     * a > b   b > c   能推出   a > c
     *
     */

    public static void main(String[] args) {
        String []strs ={"abc","ab","bc","dh","ashj","aaa"};
        //Arrays.sort(strs,new MyStringComparator());
        //for (String str : strs) {
        //    System.out.println(str);
        //}
        String lowestString = lowestString(strs);
        System.out.println(lowestString);


    }
}
