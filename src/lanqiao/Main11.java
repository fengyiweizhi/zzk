package lanqiao;

import java.util.Scanner;

/**
 * 计挑题
 * @author 风亦未止
 * @date 2021/12/26 14:24
 */
public class Main11 {
    public static String loc="green";
    public static String fort="blue";
    public static int i;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        String[] strings=new String[i];
        for (int a=0;a<i;a++){
            strings[a]=scanner.next();
        }
        dfs(strings,0);
        System.out.println(fort);
        scanner.close();

    }
    public static void dfs(String[] strings,int index){
        if (index==i){
            return;
        }
        if (loc=="green"){
            if (strings[index].equals("W")){
                loc="blue";
                fort="blue";
                dfs(strings, index+1);
            }else if (strings[index].equals("L")){
                loc="green";
                fort="blue";
            }else if (strings[index].equals("R")){
                loc="green";
                fort="blue";
            }
        }else if (loc=="red"){
            if (strings[index].equals("W")){
                loc="red";
                fort="blue";
                dfs(strings, index+1);
            }else if (strings[index].equals("L")){
                fort="red";
            }else if (strings[index].equals("R")){
                fort="red";
            }

        }else if (loc=="bule"){
            if (strings[index].equals("W")){
                loc="blue";
                fort="green";
                dfs(strings, index+1);
            }else if (strings[index].equals("L")){
                fort="red";
            }else if (strings[index].equals("R")){
                fort="red";
            }

        }

    }
}
