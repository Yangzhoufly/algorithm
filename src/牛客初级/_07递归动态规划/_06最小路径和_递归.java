package 牛客初级._07递归动态规划;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class _06最小路径和_递归 {
    public static int process(int [][]map,int i,int j){
        if(i==map.length-1 && j==map[0].length-1){
            return map[i][j];
        }
        if(i==map.length-1){
            return process(map,i,j+1)+map[i][j];
        }//只能向右走
        else if(j==map[0].length-1){
            return process(map,i+1,j)+map[i][j];
        } //只能往下走
        else{
            return Math.min(process(map,i+1,j),process(map,i,j+1))+map[i][j];
        }//下，右之间进行选择,取最小
    }

    public static void main(String[] args) {
        int map[][]={
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        System.out.println(process(map, 0, 0));
    }
}
