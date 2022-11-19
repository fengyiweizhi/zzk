package leetcode;

/**两个数之和
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums={6,3,4};
        int[] ints = twoSum(nums, 7);
        for (int a:ints) {
            System.out.println(a);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
            int[] a=new int[2];
            for(int i=0;i<=nums.length-1;i++){
                for(int j=i+1;j<=nums.length-1;j++){
                    if(nums[i]+nums[j]==target){
                        a[0]=i;
                        a[1]=j;
                    }
                }
            }
            return a;
        }
}
