package com.jdbc.bean;

/**
 * 航班
 * @author 风亦未止
 */
public class Flight {
    //编号
    private int id;
    //航班号
    private String flightId;
    //目的地
    private String city;
    //起飞日期
    private String time;

    public Flight() {
    }

    public Flight(int id, String flightId, String city, String time) {
        this.id = id;
        this.flightId = flightId;
        this.city = city;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
