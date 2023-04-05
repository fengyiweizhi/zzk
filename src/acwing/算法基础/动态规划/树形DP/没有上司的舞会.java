package acwing.算法基础.动态规划.树形DP;

/**
 * https://www.acwing.com/problem/content/287/
 *
 *Ural 大学有 N 名职员，编号为 1∼N。
 *
 * 他们的关系就像一棵以校长为根的树，父节点就是子节点的直接上司。
 *
 * 每个职员有一个快乐指数，用整数 Hi 给出，其中 1≤i≤N。
 *
 * 现在要召开一场周年庆宴会，不过，没有职员愿意和直接上司一起参会。
 *
 * 在满足这个条件的前提下，主办方希望邀请一部分职员参会，使得所有参会职员的快乐指数总和最大，求这个最大值。
 *
 * 输入格式
 * 第一行一个整数 N。
 *
 * 接下来 N 行，第 i 行表示 i 号职员的快乐指数 Hi。
 *
 * 接下来 N−1 行，每行输入一对整数 L,K，表示 K 是 L 的直接上司。（注意一下，后一个数是前一个数的父节点，不要搞反）。
 *
 * 输出格式
 * 输出最大的快乐指数。
 *
 * 数据范围
 * 1≤N≤6000,
 * −128≤Hi≤127
 * 输入样例：
 * 7
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1
 * 1 3
 * 2 3
 * 6 4
 * 7 4
 * 4 5
 * 3 5
 * 输出样例：
 * 5
 *
 * @author 风亦未止
 * @date 2023/4/5 13:36
 */
public class 没有上司的舞会 {
    private static int N = 60010;
    private static int[] v = new int[N];
    //邻接表
    private static int[] h = new int[N];
    private static int[] e = new int[N];
    private static int[] ne = new int[N];
    private static int idx = 0;
    //f[i][0] 表示 所有以 i 为根的子树中, 且不选择i的集合
    //属性 ： 最大值
    private static int[][] f = new int[N][2];
    private static int n;
    //是否有父节点
    private static boolean[] std = new boolean[N];
    
    //树形dp一下
    private static void dfs(int r){
        //初始化一下，假如选了
        f[r][1] = v[r];
        //枚举每个子节点
        for(int i = h[r]; i != -1; i = ne[i]){
            int t = e[i];
            dfs(t);
            //当前不选的情况，子节点可以选和不选
            f[r][0] += Math.max(f[t][1], f[t][0]);
            //当前选的情况，字节点只能不选；
            f[r][1] += f[t][0];
        }
    }



    private static void add(int a , int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    
    public static void main(String[] args){
        Arrays.fill(h, -1);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 1; i <= n ; i ++)v[i] = scanner.nextInt();
        for(int i = 1; i < n ;i ++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            //后一个数是前一个数的父节点
            add(b, a);
            std[a] = true;
        }
        //求父节点
        int root = 1; 
        while(std[root]) root++;
        dfs(root);
        System.out.println(Math.max(f[root][0], f[root][1]));   
    }
}
