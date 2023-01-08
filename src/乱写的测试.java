/**
 * @author 风亦未止
 * @date 2023/1/4 15:55
 */
public class 乱写的测试 {
    public static void main(String[] args) {
        int[] nums = {15,45,20,2,34,35,5,44,32,30};
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }
        System.out.println(res);
    }
}
