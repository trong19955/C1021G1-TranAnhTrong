package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcUrl ="jdbc:mysql://localhost:3306/teachers";
    private String username ="root";
    private String password ="trong123";
    private Connection connection;

    public BaseRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
    public Connection getConnection() {
        return connection;
    }

}

