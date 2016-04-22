package kr.ac.halla;

import kr.ac.jejunu.userdao.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by yeonju on 2016-04-22.
 */
public class HConnectionMaker implements ConnectionMaker {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/userinfo?characterEncoding=UTF-8", "root", "1234");
    }
}
