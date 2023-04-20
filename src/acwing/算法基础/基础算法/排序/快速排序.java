package acwing.算法基础.基础算法.排序;

import java.util.Scanner;

/**
 * @author 风亦未止
 * @date 2022/8/21 16:14
 */
public class 快速排序 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.nextInt();
        }
        quckSort(num, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
    }

    public static void quckSort(int[] num, int l, int r) {
        if (l >= r) return;
        int left = l - 1, right = r + 1;
        int p = num[l];
        while (left < right) {
            do {
                left++;
            } while (num[left] < p);
            do {
                right--;
            } while (num[right] > p);
            if (left < right) {
                int temp = num[left];
                num[left] = num[right];
                num[right] = temp;
            }
        }
        quckSort(num, l, right);
        quckSort(num, right + 1, r);
    }

}
