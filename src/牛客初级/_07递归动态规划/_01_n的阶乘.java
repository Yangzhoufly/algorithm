package 牛客初级._07递归动态规划;

public class _01_n的阶乘 {

    public static long Factorial(long n){
        if(n==1){
            return 1;
        }
        return n*Factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(Factorial(56));
    }
}
