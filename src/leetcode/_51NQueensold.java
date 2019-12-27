package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51NQueensold {

    public static List<List<String>> solveNQueens(int n) {
        if(n<=0){
            return new ArrayList<>();
        }
        //用来表示每一行放皇后的列的序号
        List<List<String>> res=new ArrayList<>();
        int []cols=new int[n];
        traceBack(res, cols,0);
        return res;
    }

    public static void traceBack(List<List<String>> res, int []cols,int row){
        if(row==cols.length ){
            if(isValid(cols)){
                res.add(parseCols(cols));
                return;
            }
            return;
        }

        for(int j=0;j<cols.length;j++){
            int temp=cols[row];
            cols[row]=j;
            traceBack(res, cols,row+1);
            cols[row]=temp;
        }

    }
    public static boolean isValid(int []cols){
        //判断cols是否有重复的数字，即同列
        for (int i = 0; i < cols.length; i++) {
            for (int j = i + 1; j < cols.length; j++) {
                if (cols[i] >= cols.length || cols[i] < 0 || cols[i] == cols[j] || (cols[i] + j - i) == cols[j] || (cols[i] - j + i) == cols[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //画图函数，请在外边判断是否合法
    public static List<String> parseCols(int []cols){
        List<String> temp=new ArrayList<>();
        String ini=".";
        for(int i=1;i<cols.length;i++){
            ini+=".";
        }

        StringBuilder sb = new StringBuilder(ini);

        for (int col : cols) {
            sb.setCharAt(col,'Q');
            temp.add(sb.toString());
            sb.setCharAt(col,'.');
        }
        return temp;
    }

    public static void main(String[] args) {
        int n=4;
        int []cols={1,0,3,2};


        //System.out.println(solveNQueens(1));
        //System.out.println(solveNQueens(2));
        //System.out.println(solveNQueens(3));
        System.out.println(solveNQueens(4));


    }
}
