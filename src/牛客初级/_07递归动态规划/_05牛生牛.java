package 牛客初级._07递归动态规划;

/*
有一头母牛，它每年年初生一头小母牛。
每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
F(n)=F(n-1)+F(n-3)
第一  项是去年的牛，继续活了下来
第二项是三年前的牛，今年可以生小牛了
 */
public class _05牛生牛 {
    public static int cow(int year){
        if(year<=4 && year>=0 ){
            return year;
        }
        return cow(year-1)+cow(year-3);
    }

    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            System.out.println(cow(i));
        }
    }
}
