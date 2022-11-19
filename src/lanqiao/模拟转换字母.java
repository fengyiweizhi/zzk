package lanqiao;
import java.util.Scanner;
/**
 * 　输入一个由小写英文字母组成的字符串，请将其中的元音字母（a, e, i, o, u)转换成大写，其它字母仍然保持小写。
 * @author 风亦未止
 * @date 2022/11/6 8:53
 */
public class 模拟转换字母 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        int length=str.length();
        for(int i=0;i<length;i++){
            char c = str.charAt(i);
            if('a'-c==0||'e'-c==0||'i'-c==0||'o'-c==0||'u'-c==0){
                str=str.replace(c,(char)(c-32));
            }
        }
        System.out.println(str);
    }
}
