import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 风亦未止
 * @date 2023/1/4 15:55
 */
public class 乱写的测试 {
    public static void main(String[] args) {
        Set<String> res = new HashSet<>();
        List<String> collect = res.stream().sorted().collect(Collectors.toList());
        System.out.println(String.valueOf(new char[]{'a','b'}));
    }
}
