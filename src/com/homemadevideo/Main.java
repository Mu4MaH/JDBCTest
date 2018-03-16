package com.homemadevideo;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;

public class Main {
//!!!! обязательно подключить драйвер с сайта https://dev.mysql.com/downloads/file/?id=476198
// file->project structure->SDKs

    public static void main(String[] args) throws ParserConfigurationException, IOException, SQLException, ClassNotFoundException {
        String username = "root";
        String passw = "1234";
        String connectionUrl = "jdbc:mysql://localhost:3306/testbase"; //можно взять из дб манагера вон там--->, из настроек подключения
        Class.forName("com.mysql.jdbc.Driver"); //нужная строчка, заучить
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, passw); //передаётся адрес базы, логин, пароль
             Statement statement = connection.createStatement())        {
            //statement.executeUpdate("CREATE TABLE playlist (id INT AUTO_INCREMENT NOT NULL , song CHAR(50) NOT NULL , author CHAR(30), PRIMARY KEY (id))");
            String songId = "1";
            String tableName = "playlist";
//            statement.executeUpdate("INSERT INTO playlist (song, author) VALUES ('Succubus', '5FDP')");
//            statement.executeUpdate("INSERT INTO users SET name='Ivan' , pass = '0000'");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM playlist");
//            while (resultSet.next()) {
//                System.out.print(resultSet.getString(3) + " " + resultSet.getString(2)); System.out.println();
//            }
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ? WHERE id>1");
            //preparedStatement.setString(1, tableName );
            preparedStatement.setString(1, tableName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString("author"));
            }
            



        }
    }
}
