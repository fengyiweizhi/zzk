package minecraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * @author 风亦未止
 * @date 2021/12/3 19:14
 */
public class Main {
    private static ArrayList<Object> scanFiles = new ArrayList<Object>();
    private static int count=0;

    public static void main(String[] args) throws FileNotFoundException {
        long currentTimeMillis = System.currentTimeMillis();
        scanFilesWithRecursion("C:\\Users\\风亦未止\\Desktop\\贴图修改\\贴图图标");

        System.out.println(scanFiles.size());
        System.out.println(count);

        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println(currentTimeMillis2-currentTimeMillis);
    }
    /**
     * TODO:递归扫描指定文件夹下面的指定文件
     * @return ArrayList<Object>
     * @throws FileNotFoundException
     */
    public static void scanFilesWithRecursion(String folderPath) throws FileNotFoundException {
        File directory = new File(folderPath);
        if(!directory.isDirectory()){
            throw new FileNotFoundException('"' + folderPath + '"' + "输入路径不是目录，请输入目录的正确路径. ^_^...^_^");
        }
        if(directory.isDirectory()){
            File [] filelist = directory.listFiles();
            for(int i = 0; i < filelist.length; i ++){
                /**如果当前是文件夹，进入递归扫描文件夹**/
                if(filelist[i].isDirectory()){
                    /**递归扫描下面的文件夹**/
                    count++;
                    scanFilesWithRecursion(filelist[i].getAbsolutePath());
                }
                /**非文件夹**/
                else{
                    String fileName = filelist[i].getName();
                    String[] split = fileName.split("\\.");
                    String name=split[0];
                    scanFiles.add(filelist[i].getAbsolutePath());
                    System.out.println(name);
//                  System.out.println(filelist[i].getAbsolutePath());
                }
            }
        }
    }


}
