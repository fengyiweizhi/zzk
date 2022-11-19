package com.express3.util;

import com.express3.bean.Express;

import java.io.*;
import java.util.HashMap;

/**
 * 序列化与反序列化
 * @author 风亦未止
 */
public class SerializeUtil {
    //序列化
    public static void serialize(HashMap<Integer,Express> object, String fileName) throws IOException {
        OutputStream ots=new FileOutputStream(fileName);
        ObjectOutputStream objO=new ObjectOutputStream(ots);
        objO.writeObject(object);
        objO.close();
    }
    //反序列化
    public static Object deSerialize(String fileName) throws IOException, ClassNotFoundException {
        InputStream its = new FileInputStream(fileName);
        ObjectInputStream objI = new ObjectInputStream(its);
        Object obj=objI.readObject();
        objI.close();
        return obj;
    }
}
