package by.javatr.controller;

import by.javatr.dao.PersistentException;
import by.javatr.dao.mysql.CompanyDaoImpl;
import by.javatr.dao.mysql.LocationDaoImpl;
import by.javatr.dao.mysql.UserDaoImpl;
import by.javatr.dao.pool.ConnectionPool;
import by.javatr.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    //private static Logger logger = Logger.getLogger(Runner.class);
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("Start runner");
//------------------------------------------------------------------------------------------------------------
// Тестирование ввода данных о user в БД
//        User user1 = new User();
//        user1.setLogin("black");
//        user1.setPassword("0154896");
//        user1.setRole(Role.USER);
//        user1.setUserStatus(UserStatus.BLOCKED);
//        UserDaoImpl userDaoTest1 = new UserDaoImpl();
//        try {
//            userDaoTest1.create(user1);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения списка всех user из БД
//        List<User> userList = new ArrayList();
//        UserDaoImpl userDaoTest2 = new UserDaoImpl();
//        try {
//            userList = userDaoTest2.read();
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//        for (User user:userList) {
//            System.out.print(user.toString());
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения  user по ID из БД
//        UserDaoImpl userDaoTest3 = new UserDaoImpl();
//        try {
//            User userTest = userDaoTest3.read(2);
//            System.out.print(userTest.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения user по login и password из БД
//        UserDaoImpl userDaoTest4 = new UserDaoImpl();
//        try {
//            User userTest = userDaoTest4.read("swallow", "swallow111");
//            System.out.print(userTest.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
//        // Тестирование получения update user
//        UserDaoImpl userDaoTest5 = new UserDaoImpl();
//        try {
//            User userTestUpdate = new User();
//            userTestUpdate.setId(2);
//            userTestUpdate.setLogin("update");
//            userTestUpdate.setPassword("update");
//            userTestUpdate.setRole(Role.USER);
//            userTestUpdate.setUserStatus(UserStatus.ACTIVE);
//            userDaoTest5.update(userTestUpdate);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование удаления user
//        UserDaoImpl userDaoTest5 = new UserDaoImpl();
//        try {
//            userDaoTest5.delete(8);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получение Company by ID
//        CompanyDaoImpl companyDao = new CompanyDaoImpl();
//        try {
//            Company company = new Company();
//            company = companyDao.read(1);
//            System.out.print(company.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получение Location by ID
        LocationDaoImpl locationDao = new LocationDaoImpl();
        try {
            Location location = new Location();
            location = locationDao.read(1);
            System.out.print(location.toString());
        } catch (PersistentException e) {
            e.printStackTrace();
        }
//------------------------------------------------------------------------------------------------------------
    }
}
