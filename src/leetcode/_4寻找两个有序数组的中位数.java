package leetcode;

public class _4寻找两个有序数组的中位数 {

    //采用归并排序
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length==0 && nums2.length!=0){
            return (nums2[nums2.length/2]+nums2[(nums2.length-1)/2])/2.0;
        }
        if(nums2.length==0 && nums1.length!=0){
            return (nums1[nums1.length/2]+nums1[(nums1.length-1)/2])/2.0;
        }

        int []all=new int [nums2.length+nums1.length];
        int i=0;//num1
        int j=0;//num2
        int k=0;//all
        while(i<nums1.length && j<nums2.length){
           all[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        }
        while(i<nums1.length){
            all[k++] =nums1[i++];
        }
        while(j<nums2.length){
            all[k++] = nums2[j++];
        }
        for (int i1 : all) {
            System.out.println(i1);
        }
        return  (all[all.length/2]+all[(all.length-1)/2])/2.0;
    }

    public static void main(String[] args) {
        //int []arr1={1,2,3,4};
        //int []arr2={2,3,4,5};
        int []arr1={1};
        int []arr2={2};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
