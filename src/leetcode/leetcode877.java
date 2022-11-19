package leetcode;

import java.util.Arrays;

/**
 * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i]。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 *
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
 *
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回true，当 Bob 赢得比赛时返回false。
 *
 * @author 风亦未止
 * @date 2022/2/17 15:55
 */
public class leetcode877 {
    public static void main(String[] args) {
        boolean b = stoneGame(new int[]{5, 3, 4, 5});
        System.out.println(b);
    }
    public static boolean stoneGame(int[] piles) {
        int alice=0;
        int bob=0;
        Arrays.sort(piles);
        for (int i=piles.length-1;i>=0;i-=2){
            alice+=piles[i];
        }
        for (int i=piles.length-2;i>=0;i-=2){
            bob+=piles[i];
        }
        if (alice>bob){
            return true;
        }
        return false;
    }
}
