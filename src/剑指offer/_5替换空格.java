package 剑指offer;

public class _5替换空格 {
    //public String replaceSpace(StringBuffer str) {
    //
    //}
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");

        System.out.println(buffer.toString().replaceAll(" ","%20"));

    }
}
