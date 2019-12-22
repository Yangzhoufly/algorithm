package 剑指offer;

public class _12矩阵中的路径 {

    public static  boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || rows<=0 || cols<=0  || str==null ||matrix.length!=rows*cols){
            return false;
        }

        boolean []visited=new boolean [rows*cols];

        int pathLength=0;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(process(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean process(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if(pathLength>=str.length){
            return true;
        }
        boolean hasPath=false;

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && ! visited[row * cols + col] ){
            pathLength++;
            visited[row * cols + col]=true;
            hasPath=process(matrix,rows,cols,row,col-1,str,pathLength,visited)
                    ||process(matrix,rows,cols,row,col+1,str,pathLength,visited)
                    ||process(matrix,rows,cols,row+1,col,str,pathLength,visited)
                    ||process(matrix,rows,cols,row-1,col,str,pathLength,visited);

            if(!hasPath){
                pathLength--;
                visited[row * cols + col]=false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char []str={'b','c','c','e','d'};
        int rows=3;
        int cols=4;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[cols*i+j]+" ");
            }
            System.out.println();
        }

        System.out.println(hasPath(matrix, rows, cols, str));
    }
}
