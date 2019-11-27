package 牛客初级._07递归动态规划;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 *使用一个cache矩阵缓存结果
 * 记忆化搜索指的是在递归的过程中，利用缓存记录每个中间过程的计算结果，
 * 如果遇到已经计算过的结果，那么直接利用缓存返回即可，无需重复计算。
 */
public class _06最小路径和_记忆化搜索 {

    public static int getMinPath(int[][] map){
        int[][] cache = new int[map.length][map[0].length];
        for(int i=0;i<cache.length;i++){
            for(int j=0;j<cache[0].length;j++) cache[i][j] = -1;
        }

        for(int i=0;i<cache.length;i++){
            for(int j=0;j<cache[0].length;j++) System.out.print(cache[i][j]+" ");
            System.out.println();
        }
        System.out.println("==========");

        return process(map,0,0,cache);
    }
    public static int process(int[][] matrix,int i,int j,int[][] cache){
        if(cache[i][j] != -1) return cache[i][j];
        if(i == matrix.length-1 && j == matrix[0].length-1) cache[i][j] = matrix[i][j];
        else if(i == matrix.length-1) cache[i][j] = process(matrix,i,j+1,cache) + matrix[i][j];
        else if(j == matrix[0].length-1) cache[i][j] = process(matrix,i+1,j,cache) + matrix[i][j];
        else cache[i][j] = Math.min(process(matrix,i,j+1,cache),process(matrix,i+1,j,cache))+ matrix[i][j];
        return cache[i][j];
    }


    public static void main(String[] args) {
        int map[][]={
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };

        System.out.println(getMinPath(map));
    }
}
