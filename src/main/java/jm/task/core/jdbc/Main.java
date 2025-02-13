package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            UserService userService = new UserServiceImpl();
            userService.createUsersTable();
            System.out.println("Таблица 'users' успешно создана (или уже существует).");

            userService.saveUser(new User("Name1", "LastName1", (byte) 20));
            userService.saveUser(new User("Name2", "LastName2", (byte) 25));
            userService.saveUser(new User("Name3", "LastName3", (byte) 31));
            userService.saveUser(new User("Name4", "LastName4", (byte) 38));
            System.out.println("Пользователи успешно добавлены.");

            userService.removeUserById(1);
            System.out.println("Пользователь с ID=1 успешно удалён.");

            List<User> users = userService.getAllUsers();
            System.out.println("Список всех пользователей:");

            for (User user : users) {
                System.out.println(user);
            }

            userService.cleanUsersTable();
            System.out.println("Таблица 'users' успешно очищена.");

            userService.dropUsersTable();
            System.out.println("Таблица 'users' успешно удалена.");

        } catch (Exception e) {
            System.out.println("Ошибка при работе с базой данных: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

