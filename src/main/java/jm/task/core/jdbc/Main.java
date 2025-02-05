package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = Util.getConnection();
            UserDao userDao = new UserDaoJDBCImpl();

            userDao.createUsersTable();
            System.out.println("Таблица 'users' успешно создана (или уже существует).");

            userDao.saveUser("Name1", "LastName1", (byte) 20);
            userDao.saveUser("Name2", "LastName2", (byte) 25);
            userDao.saveUser("Name3", "LastName3", (byte) 31);
            userDao.saveUser("Name4", "LastName4", (byte) 38);
            System.out.println("Пользователи успешно добавлены.");

            userDao.removeUserById(1);
            System.out.println("Пользователь с ID=1 успешно удалён.");

            List<User> users = userDao.getAllUsers();
            System.out.println("Список всех пользователей:");
            for (User user : users) {
                System.out.println(user);
            }

            userDao.cleanUsersTable();
            System.out.println("Таблица 'users' успешно очищена.");

            userDao.dropUsersTable();
            System.out.println("Таблица 'users' успешно удалена.");

        } catch (Exception e) {
            System.out.println("Ошибка при работе с базой данных: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Соединение с базой данных закрыто.");
                } catch (SQLException e) {
                    System.out.println("Ошибка при закрытии соединения: " + e.getMessage());
                }
            }
        }
    }
}

