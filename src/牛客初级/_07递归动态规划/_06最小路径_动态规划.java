package 牛客初级._07递归动态规划;

public class _06最小路径_动态规划 {


    private static int dpGetMinPath(int[][] map) {
        if(map==null ||map.length==0||map[0].length==0||map[0]==null){
            return 0;
        }
        int lenX=map.length;
        int lenY=map[0].length;
        int [][]dp=new int[lenX][lenY];
        dp[lenX-1][lenY-1]=map[lenX-1][lenY-1];  //右下角已知的
        for(int j=lenY-2;j>=0;j--) dp[lenX-1][j]=dp[lenX-1][j+1]+map[lenX-1][j];  //最下边一行
        for(int i=lenX-2;i>=0;i--) dp[i][lenY-1]=dp[i+1][lenY-1]+map[i][lenY-1]; //最右边一列
        for(int i=lenX-2;i>=0;i--){
            for(int j=lenY-2;j>=0;j--){
                dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+map[i][j];
            }
        }  //其余
        return dp[0][0];
    }

    public static void main(String[] args) {
        int map[][]={
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };


        int map2[][]={
                {1,3,5},
                {8,1,3},
                {5,0,6},
                {8,8,4}
        };
        System.out.println(dpGetMinPath(map));
        System.out.println(dpGetMinPath(map2));

    }
}
