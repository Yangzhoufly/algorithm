package 牛客初级._05哈希;


/**
 *
 * 岛问题
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 * 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 * 矩阵中有多少个岛？
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛。
 *
 * 思路：遍历，递归感染
 */

public class _03岛问题_并查集 {

    public static int islandNum(int [][]arr){
        if(arr==null){
            return -1;
        }
        int height=arr.length;
        int width=arr[0].length;
        int islandNum=0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==2||arr[i][j]==0){
                    continue;
                }else if(arr[i][j]==1){
                    infect(arr,i,j,height,width);
                    islandNum+=1;
                    printArr(arr);
                }
            }
            System.out.println();
        }
        return islandNum;
    }

    private static void infect(int[][] arr, int i, int j, int height, int width) {
        if (i<0 || i>height-1 || j<0 || j>width-1 ||arr==null || arr[i][j]!=1){
            return;
        }
        arr[i][j]=2;
        infect(arr,i-1,j,height,width);
        infect(arr,i+1,j,height,width);
        infect(arr,i,j-1,height,width);
        infect(arr,i,j+1,height,width);
    }


    public static void printArr(int [][]arr){
        if(arr!=null){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[i].length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][]arr={{0,0,1,0,1,0},
                     {1,1,1,0,1,0},
                     {1,0,0,0,0,0},
                     {0,0,0,0,1,1}};
        printArr(arr);
        System.out.println(islandNum(arr));
    }
}
