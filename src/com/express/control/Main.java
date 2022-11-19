package com.express.control;

import com.express.bean.Express;
import com.express.dao.ExpressDao;
import com.express.view.View;

/**
 * @author 风亦未止
 */
public class Main {
    public static void main(String[] args) {
        ExpressDao expressDao = new ExpressDao();
        View view = new View();

        view.welcome();
       out: while (true){
            int select=view.menu();
            //管理员
            if (select==1){
            in1:  while (true){
                   int select2=view.adminMenu();
                   if (select2==1){
                       //录入快递
                       Express express=view.add();
                       Express e=expressDao.findByNum(express.getNum());
                       if (e==null){
                           boolean isAdd=expressDao.add(express);
                           view.isAdd(isAdd);
                       }else {
                           view.numExist();
                       }

                   }else if (select2==2){
                       //删除快递
                      String num=view.findByNums();
                      Express findExpress=expressDao.findByNum(num);
                       boolean isExist=view.isExist(findExpress);
                       if (isExist==false){
                           continue in1;
                       }
                       view.printlnExpress(findExpress);
                       boolean isDelete=view.delete();
                       if (isDelete==false){
                           continue in1;
                       }
                       boolean successDelete=expressDao.delete(findExpress);
                       view.isDelete(successDelete);

                   }else if (select2==3){
                       //修改快递
                        String num=view.findByNums();
                        Express findExpress=expressDao.findByNum(num);
                       boolean isExist=view.isExist(findExpress);
                       if (isExist==false){
                           continue in1;
                       }
                       view.printlnExpress(findExpress);
                       Express newExpress=view.upData(findExpress);
                       boolean isUpdate=expressDao.update(findExpress,newExpress);
                       view.isUpdate(isUpdate);

                   }else if (select2==4){
                       //查看所有快递
                       Express[][] expresses=expressDao.showAll();
                       view.printAll(expresses);
                   }else if (select2==5){
                       continue out;
                   }
               }
                //用户
            }else if (select==2){
             in2:  while (true){
                   int select3=view.userMenu();
                   if (select3==1){
                       //取快递
                       int code=view.findByCode();
                       Express findExpress=expressDao.findByCode(code);
                       boolean isExist=view.isExist(findExpress);
                       if (isExist==false){
                           continue in2;

                       }
                       view.printlnExpress(findExpress);
                       boolean successDelete=expressDao.delete(findExpress);
                       view.isSuccess(successDelete);

                   }else if (select3==2){
                       continue out;
                   }
               }
            }else  if (select==3){
                break;
            }
        }

    }
}
