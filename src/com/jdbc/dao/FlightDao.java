package com.jdbc.dao;

import com.jdbc.bean.Flight;
import com.jdbc.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 风亦未止
 */
public class FlightDao extends DbUtil implements FlightImp{

    @Override
    public int delete(Flight flight) throws SQLException {
        int i = 0;
        String sql="DELETE FROM flight WHERE flightId=?";
        Connection connection = null;
        try {
            connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,flight.getFlightId());
            i = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.close();
        }
        return i;
    }

    @Override
    public int update(Flight flight) throws SQLException {
        int i=0;
        Connection connection = null;
        String sql="UPDATE flight SET flightId=?,city=?,time=? WHERE id=?";
        try {
            connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,flight.getFlightId());
            preparedStatement.setString(2,flight.getCity());
            preparedStatement.setString(3,flight.getTime());
            preparedStatement.setInt(4,flight.getId());
            try {
                i = preparedStatement.executeUpdate();
            } catch (com.mysql.cj.jdbc.exceptions.MysqlDataTruncation throwables) {
                System.out.println("时间格式输入错误！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.close();
        }
        return i;
    }

    @Override
    public List<Flight> findByTime(Flight flight) throws SQLException {
        String sql="SELECT * FROM flight WHERE time=?";
        Connection connection=null;
        Flight findFlight=null;
        List<Flight> flights=new ArrayList<>();
        try {
            connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,flight.getTime());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               findFlight = new Flight(resultSet.getInt("id"),resultSet.getString("flightId"),resultSet.getString("city"),resultSet.getString("time"));
               flights.add(findFlight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return flights;
    }

    @Override
    public List<Flight> findByCity(Flight flight) throws SQLException {
        String sql="SELECT * FROM flight WHERE city=?";
        Connection connection=null;
        Flight findFlight=null;
        List<Flight> flights=new ArrayList<>();
        try {
            connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,flight.getCity());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                findFlight = new Flight(resultSet.getInt("id"),resultSet.getString("flightId"),resultSet.getString("city"),resultSet.getString("time"));
                flights.add(findFlight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return flights;
    }

    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights=new ArrayList<>();
        Connection connection=null;
        String sql="SELECT * FROM flight";
        try {
            connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightId(resultSet.getString("flightId"));
                flight.setCity(resultSet.getString("city"));
                flight.setTime(resultSet.getString("time"));
                flights.add(flight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            connection.close();
        }
        return flights;
    }


}
