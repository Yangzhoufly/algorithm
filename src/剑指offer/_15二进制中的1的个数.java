package 剑指offer;

/**
 * 考虑到负数的存在，必须使用无符号右移，在高位插入0
 * 或者是左移
 */
public class _15二进制中的1的个数 {
    public static int NumberOf1(int n) {
        int count=0;
        while(n != 0){
            if((n & 1)==1){
                count++;
            }
            n>>>=1;
        }
        return count;
    }
    public int NumberOf1_2(int n) {
        int count=0;
        while(n != 0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(NumberOf1(-5));
    }
}
