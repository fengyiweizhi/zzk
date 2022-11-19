package lanqiao;

import java.util.*;

public class Main4 {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = in.nextInt();
        }


        Queue<Integer> queue = new LinkedList<>();
        //初始化一个元素
        queue.offer(0);

        int level = 1;
        int max = tree[0];
        int ans = level; // min level
        while (!queue.isEmpty()) {
            int size = queue.size();
            int temp = 0;

            for (int i = 0; i < size; i++) {
                int root = queue.poll();
                temp += tree[root];

                int left = (root << 1) + 1;
                if (left < n) {
                    queue.offer(left);
                }

                int right = (root << 1) + 2;
                if (right < n) {
                    queue.offer(right);
                }
            }

            if (temp > max) {
                max = temp;
                ans = level;
            }

            level++;
        }

        System.out.println(ans);
    }
}