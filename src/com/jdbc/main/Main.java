package com.jdbc.main;

import com.jdbc.bean.Flight;
import com.jdbc.dao.FlightDao;
import com.jdbc.view.View;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 风亦未止
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        //数据库准备
        FlightDao flightDao = new FlightDao();
        //视图准备
        View view = new View();
        view.welcome();
        while (true){
            int menu = view.menu();
            if (menu==1){
                //列出所有航班
                List<Flight> all = flightDao.findAll();
                view.showAll(all);
            }else if (menu==2){
                //按时间查询
                String byTime = view.findByTime();
                Flight flight = new Flight();
                flight.setTime(byTime);
                List<Flight> byTime1 = flightDao.findByTime(flight);
                view.showAll(byTime1);
            }else if (menu==3){
                //按目的地查
                String byCity = view.findByCity();
                Flight flight = new Flight();
                flight.setCity(byCity);
                List<Flight> byCity1 = flightDao.findByCity(flight);
                view.showAll(byCity1);
            }else if (menu==4){
                //删除航班
                String delete = view.delete();
                Flight flight = new Flight();
                flight.setFlightId(delete);
                int isDelete = flightDao.delete(flight);
                if (isDelete>0){
                    view.deleteS();
                }else {
                    view.deleteF();
                }
            }else if (menu==5){
                //更新航班
                Flight update = view.update();
                int isUpdate = flightDao.update(update);
                if (isUpdate>0){
                    view.updateS();
                }else {
                    view.updateF();
                }
            }else {
                break;
            }
        }
    }
}
