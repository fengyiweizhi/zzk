package com.express3.dao;

import com.express3.bean.Express;
import com.express3.util.SerializeUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * 快递数据
 * @author 风亦未止
 */
public class ExpressDao implements Serializable {
     String fileName="src\\data.json";
    //快递
    HashMap<Integer, Express> expresses=new HashMap<>();
    //存储快递
    public boolean add(Express express) throws IOException, ClassNotFoundException {
        //random为随机取件码
        int random=randomCode();
        express.setCode(random);
        expresses.put(random,express);
        SerializeUtil.serialize(expresses,fileName);
        return true;
    }
    //删除快递
    public boolean delete(Express express) throws IOException {
        int code=express.getCode();
        expresses.remove(code);
        SerializeUtil.serialize(expresses,fileName);
        return true;
    }
    //更改快递信息
    public boolean update(Express express, Express newExpress) throws IOException {
        int code=express.getCode();
        expresses.remove(code);
        expresses.put(code,newExpress);
        SerializeUtil.serialize(expresses,fileName);
        return true;
    }
    //通过查单号查询
    public Express findByNum(String num) throws IOException, ClassNotFoundException {
        expresses=(HashMap<Integer, Express>) SerializeUtil.deSerialize(fileName);
        Express express=new Express();
        Express express1;
        express.setNum(num);
        Collection<Express> value=expresses.values();
        Iterator<Express> iterator=value.iterator();
        while (iterator.hasNext()){
            express1=iterator.next();
            if (express.equals(express1)){
                return express1;
            }
        }
        return null;
    }
    //通过取件码查找
    public Express findByCode(int code) throws IOException, ClassNotFoundException {
        expresses=(HashMap<Integer, Express>) SerializeUtil.deSerialize(fileName);
        Express findExpress=expresses.get(code);
        return findExpress;
    }
    //随机取件码
    public int randomCode() throws IOException, ClassNotFoundException {
      while (true){
          int r=new Random().nextInt(900000)+100000;
          Express e=findByCode(r);
          if (e==null){
              return r;
          }
      }
    }
    //查看所有
    public  HashMap<Integer, Express> showAll() throws IOException, ClassNotFoundException {
        expresses=(HashMap<Integer, Express>) SerializeUtil.deSerialize(fileName);
        return expresses;
    }

}
