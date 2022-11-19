package lanqiao;

import java.util.Scanner;

/**
 * 小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有 NN 种蒸笼，其中第 ii 种蒸笼恰好能放 A_iA
 * i
 * ​
 *   个包子。每种蒸笼都有非常多笼，可以认为是无限笼。
 *
 * 每当有顾客想买 XX 个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有 XX 个包子。比如一共有 3 种蒸笼，分别能放 3、4 和 5 个包子。当顾客想买 11 个包子时，大叔就会选 2 笼 3 个的再加 1 笼 5 个的（也可能选出 1 笼 3 个的再加 2 笼 4 个的）。
 *
 * 当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有 3 种蒸笼，分别能放 4、5 和 6 个包子。而顾客想买 7 个包子时，大叔就凑不出来了。
 *
 * 小明想知道一共有多少种数目是包子大叔凑不出来的
 * @author 风亦未止
 * @date 2022/2/14 22:05
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[] num=new int[i];
        for (int j = 0; j < num.length; j++) {
            num[i]=scanner.nextInt();
        }
        scanner.close();

    }
}
