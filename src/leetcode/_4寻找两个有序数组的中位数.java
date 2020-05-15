package leetcode;

import myUtils.Print;
import org.junit.Test;

public class _4寻找两个有序数组的中位数 {

    //采用归并排序 时间复杂度O(n+m)
    public  double findMedianSortedArrays01(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length != 0) {
            return (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) / 2.0;
        }
        if (nums2.length == 0 && nums1.length != 0) {
            return (nums1[nums1.length / 2] + nums1[(nums1.length - 1) / 2]) / 2.0;
        }

        int[] all = new int[nums2.length + nums1.length];
        int i = 0;//num1
        int j = 0;//num2
        int k = 0;//all
        while (i < nums1.length && j < nums2.length) {
            all[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        }
        while (i < nums1.length) {
            all[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            all[k++] = nums2[j++];
        }
        Print.printSortArray(all);

        return (all[all.length / 2] + all[(all.length - 1) / 2]) / 2.0;
    }


    @Test
    public  void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3, 4, 5};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length+nums2.length==0){
            return 0;
        }
        return 0;
    }
}
