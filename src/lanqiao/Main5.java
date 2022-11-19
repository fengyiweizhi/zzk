package lanqiao;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main5 {
    public static int  N,ans=0,cnt=0;//ans面积，cnt已经种的树
    public static int[]x=new int [31];
    public static int[]y=new int [31];
    public static int[]r=new int [31];
    public static int[]tree=new int [31];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        N=scan.nextInt();
        for(int i=0;i<N;i++){
            //第i课树的横纵坐标和半径。
            x[i]=scan.nextInt();
            y[i]=scan.nextInt();
            r[i]=scan.nextInt();
        }

        plant(0,0,0);
        System.out.print(ans);
        scan.close();
    }

    public static void plant(int i,int area,int cnt){
        if(i==N){
            //最后一棵树
            if(area>ans){
                //记录最大面积
                ans=area;
            }
            return;
        }
        plant(i+1,area,cnt);
        for(int j=0;j<cnt;j++){
            //
            if(dis(i,tree[j])){
                //两树圆心距离小于两棵树的半径和
                return ;
            }
        }
        //选择种植的树，记录下标
        tree[cnt]=i;
        plant(i+1,area+r[i]*r[i],cnt+1);
    }

    public static boolean dis(int a,int b){
        //判断两棵树圆心的距离是否小于两棵树的半径和
        return (Math.pow(x[a]-x[b],2)+Math.pow(y[a]-y[b],2))<Math.pow(r[a]+r[b],2);
    }
}
