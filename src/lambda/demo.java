package lambda;

/**
 * @author 风亦未止
 * @date 2022/11/5 15:45
 */
public class demo {

    public static void main(String[] args) {

        int sum = sum((a, b) -> a+b);
        System.out.println(sum);
    }

    public static int sum(MyMath s){
        int a=1;
        int b=2;
        return s.analysis(a,b);
    }

     interface MyMath{
         int analysis(int i, int b);

         default int analysis2(int i, int b) {
             return i+b;
         }
     }
}
