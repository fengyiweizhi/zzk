package com.jdbc.dao;

import com.jdbc.bean.Flight;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 风亦未止
 */
public interface FlightImp {
     //删除航班
     int delete(Flight flight) throws SQLException;
     //更新航班
     int update(Flight flight) throws SQLException;
     //按起飞时间查询
     List<Flight> findByTime(Flight flight) throws SQLException;
     //按目的地查询
     List<Flight> findByCity(Flight flight) throws SQLException;
     //列出所有
     List<Flight> findAll() throws SQLException;

}
