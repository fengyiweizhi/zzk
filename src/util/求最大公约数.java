package util;

/**
 * @author 风亦未止
 * @date 2022/11/5 22:26
 */
public class 求最大公约数 {

    // 欧几里德算法求最大公约数

    /**
     * 1997 / 615 = 3 (余 152)
     * <p>
     * 615 / 152 = 4(余7)
     * <p>
     * 152 / 7 = 21(余5)
     * <p>
     * 7 / 5 = 1 (余2)
     * <p>
     * 5 / 2 = 2 (余1)
     * <p>
     * 2 / 1 = 2 (余0)
     * <p>
     * 至此，最大公约数为1
     *
     * @param p
     * @param q
     * @return
     */
    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
