package jm.task.core.jdbc.util;
import org.hibernate.SessionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/newdb2";
    private static final String USER = "root";
    private static final String PASSWORD = "Borisov98";

    private static SessionFactory sessionFactory;
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }

        return null;
    }



    }


