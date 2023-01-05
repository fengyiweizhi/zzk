package acwing.算法基础.基础算法.离散化;

import java.util.*;
import java.util.stream.Collectors;

/**
 *假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。
 *
 * 现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。
 *
 * 接下来，进行 m 次询问，每个询问包含两个整数 l 和 r，你需要求出在区间 [l,r] 之间的所有数的和。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 n 行，每行包含两个整数 x 和 c。
 *
 * 再接下来 m 行，每行包含两个整数 l 和 r。
 *
 * 输出格式
 * 共 m 行，每行输出一个询问中所求的区间内数字和。
 *
 * 数据范围
 * −109≤x≤109,
 * 1≤n,m≤105,
 * −109≤l≤r≤109,
 * −10000≤c≤10000
 * 输入样例：
 * 3 3
 * 1 2
 * 3 6
 * 7 5
 * 1 3
 * 4 6
 * 7 8
 * 输出样例：
 * 8
 * 0
 * 5
 * @author 风亦未止
 * @date 2022/12/1 16:51
 */
public class 区间和 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> all=new ArrayList<>();
        HashMap<Integer,Integer> adds=new HashMap<>();
        for(int i=0;i<n;i++){
            int nums=scanner.nextInt();
            int c=scanner.nextInt();
            adds.put(nums,adds.getOrDefault(nums,0)+c);
            all.add(nums);
        }
        ArrayList<int[]> query=new ArrayList<>();
        for(int i=0;i<m;i++){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            query.add(new int[]{l,r});
            all.add(l);
            all.add(r);
        }
        List<Integer> newAll = all.stream().distinct().sorted().collect(Collectors.toList());
        int[] pre = new int[newAll.size()+1];

        for(int i=1;i<=newAll.size();i++){
            pre[i]=pre[i-1]+adds.getOrDefault(newAll.get(i-1),0);
        }
        for(int[] q : query){
            int l=newAll.indexOf(q[0]);
            int r=newAll.indexOf(q[1]);
            System.out.println(pre[r+1]-pre[l]);
        }
    }

}
