package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51NQueens {

    public static List<List<String>> solveNQueens(int n) {
        if(n<=0){
            return new ArrayList<>();
        }
        List<List<String>> res=new ArrayList<>();

        //用来表示每一行放皇后的列的序号
        int []cols=new int[n];
        traceBack(res, cols,0);
        return res;
    }

    public static void traceBack(List<List<String>> res, int []cols,int row){
        if(row==cols.length ){
            res.add(parseCols(cols));
            return;
        }
        for(int j=0;j<cols.length;j++){
            int temp=cols[row];
            cols[row]=j;
            if(isValid2(cols,row)){
                traceBack(res, cols,row+1);
            }
            cols[row]=temp;
        }
    }

    //太费时间了，不必每一次全都判定,只需要和最新插入的比，后面没有更新的也不用管
    public static boolean isValid2(int []cols,int row){
        //同列，对角线
        for(int i=0;i<row;i++){
            if(cols[i]==cols[row] || Math.abs(cols[row]-cols[i]) ==Math.abs(row-i)){
                return false;
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

        //System.out.println(solveNQueens(1));
        //System.out.println(solveNQueens(2));
        //System.out.println(solveNQueens(3));
        System.out.println(solveNQueens(4));


    }
}
