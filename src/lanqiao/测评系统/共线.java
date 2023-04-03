package lanqiao.测评系统;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 问题描述
 * 　　给定2维平面上n个整点的坐标，一条直线最多能过几个点？
 * 输入格式
 * 　　第一行一个整数n表示点的个数
 * 　　以下n行，每行2个整数分别表示每个点的x,y坐标。
 * 输出格式
 * 　　输出一个整数表示答案。
 * 样例输入
 * 5
 * 0 0
 * 1 1
 * 2 2
 * 0 3
 * 2 3
 * 样例输出
 * 3
 * 数据规模和约定
 * 　　n<=1500，数据保证不会存在2个相同的点。
 * 　　点坐标在int范围内
 *
 *
 * @author 风亦未止
 * @date 2023/3/30 22:24
 */
public class 共线 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[][] po = new int[n][2];
        for(int i = 0; i < n ; i++){
            po[i][0] = scanner.nextInt();
            po[i][1] = scanner.nextInt();
        }
        Arrays.sort(po, (a, b) ->{ return a[0] -b[0]; });
        Map<Double, Integer> map = new HashMap<>();
        for(int i = 0; i < n - 1 ; i++){
            int x1 = po[i][0];
            int y1 = po[i][1];
            int x2 = po[i + 1][0];
            int y2 = po[i + 1][1];
            if(map.get( (double)(y1 - y2) / (x1 - x2)) == null){
                map.put((double)(y1 - y2) / (x1 - x2), 2);
            }else{
                map.put((double)(y1 - y2) / (x1 - x2), map.get( (double)(y1 - y2) / (x1 - x2)) + 1);
            }

        }
        int max = 0;
        for(Double key : map.keySet()){
            max = Math.max(max , map.get(key));
        }
        System.out.println(max);
    }
}
