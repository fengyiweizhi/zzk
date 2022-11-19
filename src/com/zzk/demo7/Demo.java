package com.zzk.demo7;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * xml解析
 * xpath解析
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args) throws IOException, DocumentException {
        //  创建文件流
        FileInputStream fileInputStream = new FileInputStream("D://demo.xml");
        //创建解析对象 
        SAXReader sr=new SAXReader();
        //解析对象读取并得到文档对象
        Document read = sr.read(fileInputStream);
        //通过文档对象读取根元素
        Element rootElement = read.getRootElement();
        //开始解析
        System.out.println(rootElement.getName());

        //操作一波
        String pepole1 = rootElement.elementText("pepole1");
        System.out.println(pepole1);

        //xpath解析
        List<Node> list = read.selectNodes("//name");
        for (int i = 0; i <list.size(); i++) {
            Node node = list.get(i);
            System.out.println(node.getText());
        }

        //关闭文件流
        fileInputStream.close();
    }
}
