package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 *
 * @author 风亦未止
 * @date 2022/12/29 22:26
 */
public class 至少在两个数组中出现的值2032 {

    public static void main(String[] args) {


    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] map = new int[101];
        Set<Integer> set1 = new HashSet<>();
        for (int a : nums1) {
            set1.add(a);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int a : nums2) {
            set2.add(a);
        }
        Set<Integer> set3 = new HashSet<>();
        for (int a : nums3) {
            set3.add(a);
        }
        List<Integer> collect = set1.stream().collect(Collectors.toList());
        for (Integer a : collect) {
            map[a]++;
        }
        List<Integer> collect2 = set2.stream().collect(Collectors.toList());
        for (Integer a : collect2) {
            map[a]++;
        }

        List<Integer> collect3 = set3.stream().collect(Collectors.toList());
        for (Integer a : collect3) {
            map[a]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(map[i]>=2){
                res.add(i);
            }
        }
        return res;
    }
}
