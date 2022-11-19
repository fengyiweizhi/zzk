package com.express.dao;

import com.express.bean.Express;

import java.util.Random;

/**
 * 快递数据
 * @author 风亦未止
 */
public class ExpressDao {
    //快递
    Express[][] expresses=new Express[10][10];
    //存储快递
    public boolean add(Express express){
        for (int a=0;a<10;a++){
            for (int b=0;b<10;b++){
                if (expresses[a][b]==null){
                    int r=randomCode();
                    express.setCode(r);
                    expresses[a][b]=express;
                    return true;
                }
            }
        }
        return false;
    }
    //删除快递
    public boolean delete(Express express){
        for (int a=0;a<10;a++){
            for (int b=0;b<10;b++){
                if (express.equals(expresses[a][b])){
                    expresses[a][b]=null;
                    return true;
                }
            }
        }
        return false;
    }
    //更改快递信息
    public boolean update(Express express,Express newExpress){
        for (int a =0;a<100;a++){
            for(int b=0;b<100;b++){
                if (express.equals(expresses[a][b])){
                    expresses[a][b]=newExpress;
                    return true;
                }
            }
        }
        return false;
    }
    //通过查单号查询
    public Express findByNum(String num){
        Express express = new Express();
        express.setNum(num);
        for (int a = 0;a<10;a++){
            for (int b = 0;b<10;b++){
                if (express.equals(expresses[a][b])){
                    return expresses[a][b];
                }
            }
        }
        return null;
    }
    //通过取件码查找
    public Express findByCode(int code){
        for (int a=0;a<10;a++){
            for (int b=0;b<10;b++){
                try {
                    if (expresses[a][b].getCode()==code){
                        return expresses[a][b];
                    }
                } catch (NullPointerException e) {
                    return null;
                }
            }
        }
        return null;
    }
    //随机取件码
    public int randomCode(){
      while (true){
          int r=new Random().nextInt(900000)+100000;
          Express e=findByCode(r);
          if (e==null){
              return r;
          }
      }
    }
    //查看所有
    public Express[][] showAll(){
        return expresses;
    }

}
