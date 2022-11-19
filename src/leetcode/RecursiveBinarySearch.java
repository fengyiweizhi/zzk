package leetcode;

/**
 * 递归版二分查找
 * @author 风亦未止
 * @date 2021/9/24 17:05
 */
public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int findNum=15;
        int[] nums={1,2,3,4,5,9,15};
        int length = nums.length-1;
        int front=0;
        int i = binarySearch(findNum, front, length, nums);
        System.out.println(i);

    }
    public static int binarySearch(int findNum,int front,int end,int[] nums){
        if (end<front){
            return -1;
        }
        int mid=(front+end)/2;
        if (findNum<nums[mid]){
           return binarySearch(findNum, front, mid-1, nums);
        }
        if(findNum>nums[mid]){
            return binarySearch(findNum, mid+1, end, nums);
        }
        return mid;
    }

}
