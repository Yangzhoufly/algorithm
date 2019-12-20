package 牛客初级._07递归动态规划;

import java.util.Scanner;

//https://www.nowcoder.com/questionTerminal/708f0442863a46279cce582c4f508658

public class _08背包提交模板 {

    //自己写的
    private static int bag(int[] volume, int[] value,int bagVo,int index,int sumVo,int sumVa) {
        if(sumVo>bagVo){
            return 0;
        }
        if(index==volume.length){
            return sumVa;
        }
        int choose=bag(volume,value,bagVo,index+1,sumVo+volume[index],sumVa+value[index]);
        int notChoose=bag(volume,value,bagVo,index+1,sumVo,sumVa);
        return Math.max(choose,notChoose);
    }

    //3
    private static int bag3(int[] volume, int[] value,int bagVo,int index,int sumVo) {
        if(index==volume.length){
            return 0;
        }
        int choose= sumVo+volume[index]<=bagVo?  bag3(volume,value,bagVo,index+1,sumVo+volume[index])+value[index]  : 0;
        int notChoose=bag3(volume,value,bagVo,index+1,sumVo);
        return Math.max(choose,notChoose);
    }


    public static int dpBag(int[] volume, int[] value,int bagVo){
        int lenX_index=volume.length+1;
        int lenY_sumVo=bagVo+1;
        int [][]dp=new int[lenX_index][lenY_sumVo]; //初始情况下就全是0了
        for(int i=lenX_index-2;i>=0;i--){
            for(int s=lenY_sumVo-1;s>=0;s--){
                int choose=s+volume[i]<=bagVo ? dp[i+1][s+volume[i]]+value[i]  : 0 ;
                int notChoose=dp[i+1][s];
                dp[i][s]=Math.max(choose,notChoose);
            }
        }
        return dp[0][0];
    }//测试通过

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int bagVo = sc.nextInt();
        int nums = sc.nextInt();
        int[] volume = new int[nums + 1];
        int[] value = new int[nums + 1];
        for(int i = 1; i < nums + 1; i++){
            volume[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        System.out.println(dpBag(volume, value, bagVo));
    }
}
