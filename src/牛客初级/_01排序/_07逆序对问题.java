package 牛客初级._01排序;

/**
 * 逆序对问题：
 *
 * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序对。
 * 给一列数a1,a2,…,an，求它的逆序对数，即有多少个有序对(i,j)，使得i<j但ai>aj。n可以高达10^6。
 *
 * 由于n的数量级到了10^6，所以采用O(n^2)及以上的时间复杂度肯定会超时，所以必须选取O(n*logn)及以下时间复杂度的算法。
 *
 * 例子： {1, 3, 4, 2, 5}
 * 结果：（3,2）、（4,2）
 *
 * 逆序对的求解思路和归并排序很像，尝试写出分治三部曲：
 划分问题：将原序列分解成尽可能长度相等的两个子序列
 递归过程：统计左子序列和右子序列的逆序对
 合并问题：统计左右子序列合并后的逆序对
 *
 *参考： https://blog.csdn.net/q547550831/article/details/51532491
 *       https://blog.csdn.net/LYN9822/article/details/86314732
 */

public class _07逆序对问题 {

    private static void findBigSmall(int[] arr) {
        if(arr==null || arr.length<2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if(L==R){
            return;
        }
        int mid=(L+R)/2;
        mergeSort(arr,L,mid);     //对左边排序
        mergeSort(arr,mid+1,R);//对右边排序
        merge(arr,L,mid,R);       //merge,d对左右两边排序好的数组进行合并
    }

    private static void merge(int[] arr, int L, int mid,int R) {
        int []temp=new int[R-L+1];//创建一个辅助数组
        int pointTemp=0;          //指向辅助数组的头部
        int pL=L;                 //指向左边排好序的头部
        int pR=mid+1;             //指向右边排好序的头部

        //将arr中的数据按大小放入辅助数组
        while(pL<=mid && pR<=R){
            //满足条件,那么左边数组的 【pL，mid】和当前的pR构成一组逆序对
            if(arr[pL]>arr[pR]){
                for(int i=pL;i<=mid;i++) {
                    System.out.println("(" + arr[i] + "," + arr[pR] + ")");
                }
            }
            //这样写能进一步保证稳定性
            temp[pointTemp++]=arr[pL]<=arr[pR]?arr[pL++]:arr[pR++];
        }

        //将剩下的数据放入辅助数组
        while(pL<=mid){
            temp[pointTemp++]=arr[pL++];
        }
        while(pR<=R){
            temp[pointTemp++]=arr[pR++];
        }

        //将辅助数组中的值放回原始的arr
        for(int i=0;i<temp.length;i++){
            arr[L+i]=temp[i];
        }
    }

    public static void main(String[] args) {
        int [] arr ={1,4,3,2,5};
        int [] arr2 ={5,4,3,2,1};
        findBigSmall(arr);

        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
    }


}
