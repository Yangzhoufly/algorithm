package 剑指offer;


/**
 * 数组从左到右，从上到下是递增的
 * 可以选择右上，也可以选择左下
 * 本例子中选择的是右上
 */
public class _4二维数组中查找 {

    public static  boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = 0;//行
        int column = array[0].length - 1;//列

        while (row < array.length && column >=0) {
            if(array[row][column]==target){
                return true;
            }else if(array[row][column]>target){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]arr={
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(Find(7, arr));
    }
}
