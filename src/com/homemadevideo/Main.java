package com.homemadevideo;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SQLException, ClassNotFoundException {
        String username = "root";
        String passw = "1234";
        String connectionUrl = "jdbc:mysql://localhost:3306/testbase"; //можно взять из дб манагера вон там--->, из настроек подключения
        Class.forName("com.mysql.jdbc.Driver"); //нужная строчка, заучить
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, passw)){ //передаётся адрес базы, логин, пароль
            System.out.print("YESSSS!!!Connected"); //тут можно творить херню запросами)))
        }
    }
}
