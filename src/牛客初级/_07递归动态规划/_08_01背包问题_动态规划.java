package 牛客初级._07递归动态规划;
//https://www.nowcoder.com/questionTerminal/708f0442863a46279cce582c4f508658
public class _08_01背包问题_动态规划 {
    public static void main(String[] args) {
        int[]volume={3,2,4};
        int[]value={5,4,2};
        int bagVo=6;
        System.out.println(dpBag(volume, value, bagVo));
    }
    public static int dpBag(int[] volume, int[] value,int bagVo){
        int lenX_index=volume.length+1;
        int lenY_sumVo=bagVo+1;
        int [][]dp=new int[lenX_index][lenY_sumVo]; //初始情况下就全是0了
        for(int i=lenX_index-2;i>=0;i--){
            for(int s=lenY_sumVo-1;s>=0;s--){
                int choose=s+volume[i]<=bagVo ? dp[i+1][s+volume[i]]+value[i]  : 0 ;
                int notChoose=dp[i+1][s];//少写了这一行
                dp[i][s]=Math.max(choose,notChoose);//少写了这一行
            }
        }
        return dp[0][0];
    }
    //递归
    private static int bag3(int[] volume, int[] value,int bagVo,int index,int sumVo) {
        if(index==volume.length){
            return 0;
        }
        int choose= sumVo+volume[index]<=bagVo?  bag3(volume,value,bagVo,index+1,sumVo+volume[index])+value[index]  : 0;
        int notChoose=bag3(volume,value,bagVo,index+1,sumVo);
        return Math.max(choose,notChoose);
    }

}

