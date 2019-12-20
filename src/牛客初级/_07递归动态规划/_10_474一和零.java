package 牛客初级._07递归动态规划;

import jdk.nashorn.internal.ir.CallNode;
//https://leetcode-cn.com/problems/ones-and-zeroes/

/**
 * 还是一个01背包的问题，选择这个字符串需要组成，还是不需要
 */
public class _10_474一和零 {

    public static class Str{
        int num_0;
        int num_1;

        public Str(int num_0, int num_1) {
            this.num_0 = num_0;
            this.num_1 = num_1;
        }
    }
    public static Str[] count01(String[] strs){
        Str []strCount= new Str[strs.length];
        for (int i=0;i<strs.length;i++){
            int num_0=0;
            int num_1=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0') num_0++;
                else if(strs[i].charAt(j)=='1') num_1++;
                strCount[i]=new Str(num_0,num_1);
            }
        }
        return strCount;
    }

    public static void main(String[] args) {
        String []arr1={"10", "0001", "111001", "1", "0"};
        int m1=5;//0
        int n1=3;//1

        String []arr2={"10", "0", "1"};
        int m2=1;
        int n2=1;

        String []arr3={"0", "0", "1","0","0", "0","0", "0","0", "0","0", "0"};
        int m3=6;
        int n3=6;

        int res=findMaxForm(arr1, m1, n1);
        System.out.println(res);
        System.out.println(findMaxForm(arr2, m2, n2));
        System.out.println(findMaxForm(arr3, m3, n3));
    }

    public static int findMaxForm(String[] strs, int m0, int n1) {
        Str[] str01 = count01(strs);
        //return process(str01,m0,n1,0);
        return dp_process(str01,m0,n1);
    }

    public static int dp_process(Str[] str01,int m0,int n1){
        int lenX_index=str01.length+1;
        int lenY_m0=m0+1;
        int lenZ_n1=n1+1;
        int [][][] dp=new int[lenX_index][lenY_m0][lenZ_n1];
        for(int i=lenX_index-2;i>=0;i--){
            for(int m=lenY_m0-1;m>=0;m--){
                for(int n=lenZ_n1-1;n>=0;n--){
                    int choose=m>=str01[i].num_0 && n>=str01[i].num_1 ? dp[i+1][m-str01[i].num_0][n-str01[i].num_1] +1 : dp[i+1][m][n];
                    int notChoose= dp[i+1][m][n];
                    dp[i][m][n]=Math.max(choose,notChoose);
                }
            }
        }
        return dp[0][m0][n1];
    }

    public static int process(Str[] str01,int m0,int n1,int index){
        if(index==str01.length){
            return 0;
        }
        int choose=  m0>=str01[index].num_0 &&  n1 >= str01[index].num_1  ? process(str01,m0-str01[index].num_0,n1 - str01[index].num_1,index+1)+1 :process(str01,m0,n1,index+1);
        int notChoose=process(str01,m0,n1,index+1);
        return Math.max(choose,notChoose);
    }
}
