package lanqiao;

/**
 * @author 风亦未止
 * @date 2022/11/5 21:24
 */
public class 门牌 {
    public static void main(String[] args) {
        int count=0;
        for(int i=1;i<2020;i++){
            String nums=String.valueOf(i);
            int index=0;
            while(index<nums.length()){
                if(nums.charAt(index)=='2')count++;
                index++;
            }
        }
        System.out.println(count);
    }
}
