package acwing.算法基础.数据结构.哈希表;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/842/
 *
 * 维护一个集合，支持如下几种操作：
 *
 * I x，插入一个数 x；
 * Q x，询问数 x 是否在集合中出现过；
 * 现在要进行 N 次操作，对于每个询问操作输出对应的结果。
 *
 * 输入格式
 * 第一行包含整数 N，表示操作数量。
 *
 * 接下来 N 行，每行包含一个操作指令，操作指令为 I x，Q x 中的一种。
 *
 * 输出格式
 * 对于每个询问指令 Q x，输出一个询问结果，如果 x 在集合中出现过，则输出 Yes，否则输出 No。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤N≤105
 * −109≤x≤109
 * 输入样例：
 * 5
 * I 1
 * I 2
 * I 3
 * Q 2
 * Q 5
 * 输出样例：
 * Yes
 * No
 *
 * @author 风亦未止
 * @date 2023/1/6 22:36
 */
public class 模拟散列表 {
    public static int N = 100003;
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int idx = 0;

    public static void insert(int x){
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx;
        idx++;
    }

    public static boolean find(int x){
        int k = (x % N + N) % N;
        for(int i = h[k]; i != -1; i = ne[i]){
            if(e[i] == x){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Arrays.fill(h,-1);
        while(m-- > 0 ){
            String opt = scanner.next();
            int x = scanner.nextInt();
            if("I".equals(opt)){
                insert(x);
            }
            if("Q".equals(opt)){
                System.out.println(find(x)?"Yes":"No");
            }
        }

    }


}
