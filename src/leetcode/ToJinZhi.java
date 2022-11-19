package leetcode;

/**
 * @author 风亦未止
 * @date 2021/9/15 17:55
 */
public class ToJinZhi {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        System.out.println(Integer.toString(i,2));
//        int count=0;
//        for (int j = 1; j < 32; j++) {
//            if ((i&(1<<j))==(1<<j)){
//                count++;
//            }
//        }
//        System.out.println(count);
        int i = oneNum(3);
        System.out.println(i);
    }

    public static int oneNum(int num){
        int count=0;
//        for (int j = 1; j <=32; j++) {
//            if ((num&(1<<j))==(1<<j)){
//                count++;
//            }
//        }
        while (num!=0){
            num=((num-1)&num);
            count++;
        }
        return count;
    }
}
