package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中0<= i <j <k <n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 *
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * @author 风亦未止
 * @date 2022/2/20 16:22
 */
public class leetcode1395 {
    public static void main(String[] args) {
        int i = numTeams(new int[]{2,5,3,4,1});
        System.out.println(i);
    }

    public static int numTeams(int[] rating) {
        int n=rating.length;
        if(n<=2){
            return 0;   //总共没有3个士兵
        }
        int[] minToMax2=new int[n];     //minToMax2[j]代表,i->j中间有多少数rating[j]小
        int[] maxToMin2=new int[n];     //maxToMin2[j]代表,i->j中间有多少数rating[j]大
        int i,j,result=0;
        for(i=0;i<n;i++){
            minToMax2[i]=0;
            maxToMin2[i]=0;
            for(j=i-1;j>=0;j--){
                if(rating[i]>rating[j]){
                    minToMax2[i]++;     //计算有多少数比rating[i]小
                    result+=minToMax2[j];       //rating[i]>rating[j],rating[j]比minToMax2[j]个下标小于j的数大,所以{rating[k](k<j)<rating[j]<rating[i]}共有minToMax2[j种情况]
                }
                if(rating[i]<rating[j]){
                    maxToMin2[i]++;
                    result+=maxToMin2[j];
                }
            }
        }
        return result;




        //暴力枚举法
//        int result=0;
//        for(int i=0;i<rating.length;i++){
//                for (int j=i+1;j<rating.length;j++){
//                    for (int k=j+1;k< rating.length;k++){
//                        if ((rating[i]<rating[j]&&rating[j]<rating[k])||(rating[i]>rating[j]&&rating[j]>rating[k])){
//                            result++;
//                        }
//                    }
//                }
//        }
//        return result;

    }

}
