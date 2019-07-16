package by.javatr.controller;
import by.javatr.dao.BicycleDao;
import by.javatr.dao.Dao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.mysql.*;
import by.javatr.entity.*;
import by.javatr.entity.en_um.*;
import com.mysql.jdbc.Blob;
import com.sun.deploy.security.CertUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Start runner");
//------------------------------------------------------------------------------------------------------------
// Тестирование ввода данных о user в БД
        Dao dao = null;
        User user1 = new User();
        user1.setLogin("tera");
        user1.setPassword("1111111111");
        user1.setRole(Role.USER);
        user1.setUserStatus(UserStatus.BLOCKED);
        try {
            dao = DAOSqlFactory.getInstance().get(DaoImpl.UserDaoImpl);
            dao.create(user1);
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
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
        // Тестирование получение Company by AccountNumber
//        CompanyDaoImpl companyDao = new CompanyDaoImpl();
//        try {
//            Company company = new Company();
//            company = companyDao.readByAccountNumberOfPayer(192693197);
//            System.out.print(company.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }

//------------------------------------------------------------------------------------------------------------
        // Тестирование создания Company by AccountNumber
//        CompanyDaoImpl companyDao = new CompanyDaoImpl();
//        try {
//            Company company = new Company();
//            company.setName("Limited liability company Enjoyment");
//            company.setAccountNumberOfPayer(15978958);
//            Integer id = companyDao.create(company);
//            System.out.print(company.toString());
//            System.out.print(id.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование  удаления Company
//        CompanyDaoImpl companyDao = new CompanyDaoImpl();
//        try {
//            companyDao.delete(5);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Location by ID
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        try {
//            Location location = new Location();
//            location = locationDao.read(1);
//            System.out.print(location.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Location by Company_ID
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        List<Location> locationList = new ArrayList();
//        try {
//            locationList = locationDao.readByCompanyId(1);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//        for (Location location:locationList) {
//            System.out.print(location.toString());
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Location by country
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        List<Location> locationList = new ArrayList();
//        try {
//            locationList = locationDao.readByCountry("Poland");
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//        for (Location location:locationList) {
//            System.out.print(location.toString());
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Location by city
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        List<Location> locationList = new ArrayList();
//        try {
//            locationList = locationDao.readByCity("Poznan");
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//        for (Location location : locationList) {
//            System.out.print(location.toString());
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование создания Location
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        Location location = new Location();
//        location.setName("Basic");
//        Company company = new Company();
//        company.setName("Limited liability company Enjoyment");
//        company.setAccountNumberOfPayer(15978958);
//        location.setCompany(company);
//        location.setCountry(Country.BELARUS);
//        location.setCity(City.GRODNO);
//        location.setStreet("Yastnaja");
//        location.setHouse("2A");
//        location.setOffice("12");
//        location.setPhone(80297568900L);
//        location.setSecondPhone(80297568989L);
//        location.setPhoto("There will be a relative path to the photo!");
//        try {
//            locationDao.create(location);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование update Location
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        Location location = new Location();
//        location.setName("New");
//        location.setId(18);
//        Company company = new Company();
//        company.setName("Limited liability company Enjoyment");
//        company.setAccountNumberOfPayer(15978958);
//        location.setCompany(company);
//        location.setCountry(Country.BELARUS);
//        location.setCity(City.GRODNO);
//        location.setStreet("Yastnaja");
//        location.setHouse("2A");
//        location.setOffice("12");
//        location.setPhone(80297568900L);
//        location.setSecondPhone(80297568989L);
//        location.setPhoto("There will be a relative path to the photo!");
//        try {
//            locationDao.update(location);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование  удаления Location
//        LocationDaoImpl locationDao = new LocationDaoImpl();
//        try {
//            locationDao.delete(18);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Price by ID
//        PriceDaoImpl priceDao = new PriceDaoImpl();
//        try {
//            Price price = new Price();
//            price = priceDao.read(1);
//            System.out.print(price.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения всех Price By Currency
//        PriceDaoImpl priceDao = new PriceDaoImpl();
//        try {
//            List<Price> priceList = new ArrayList<>();
//            Currency currencyTest = Currency.BYN;
//            priceList = priceDao.readByCurrency(currencyTest);
//            for (Price price:priceList) {
//            System.out.print(price.toString());
//        }
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения всех Price
//        PriceDaoImpl priceDao = new PriceDaoImpl();
//        try {
//            List<Price> priceList = new ArrayList<>();
//            priceList = priceDao.read();
//            for (Price price:priceList) {
//            System.out.print(price.toString());
//        }
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование создания Price
////        Price priceTest = new Price();
////        priceTest.setCurrency(Currency.BYN);
////        TimeUnit timeUnit = TimeUnit.HOUR;
////        priceTest.setUnitTime(timeUnit);
////        priceTest.setBookMaxTimeInMin(60);
////        priceTest.setRate(new BigDecimal(0.05));
////        priceTest.setBookRate(new BigDecimal(0));
////
////    PriceDaoImpl priceDao = new PriceDaoImpl();
////        try {
////            priceDao.create(priceTest);
////        } catch (PersistentException e) {
////            e.printStackTrace();
////        }
//
////------------------------------------------------------------------------------------------------------------
        // Тестирование update Price
//        Price priceUpdate = new Price();
//        priceUpdate.setId(1);
//        priceUpdate.setCurrency(Currency.BYN);
//        TimeUnit timeUnit = TimeUnit.HOUR;
//        priceUpdate.setUnitTime(timeUnit);
//        priceUpdate.setBookMaxTimeInMin(30);
//        priceUpdate.setRate(new BigDecimal(0.01));
//        priceUpdate.setBookRate(new BigDecimal(0));
//
//        PriceDaoImpl priceDao = new PriceDaoImpl();
//        try {
//            priceDao.update(priceUpdate);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
        // Тестирование delete Price
//        PriceDaoImpl priceDaoImpl = new PriceDaoImpl();
//        try {
//            priceDaoImpl.delete(5);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
    // Тестирование получения bicycle by ID
//        BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle = bicycleDao.read(1);
//            System.out.print(bicycle.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }}
//------------------------------------------------------------------------------------------------------------
// Тестирование получения bicycle by ID
//        BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle = bicycleDao.read(1);
//            System.out.print(bicycle.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }}
//------------------------------------------------------------------------------------------------------------
        // Тестирование создания bicycle
//        BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle.setModel("BY-1456");
//            bicycle.setBicycleType(BicycleType.UNIVERSAL);
//            Short year = 2019;
//            bicycle.setProductionYear(year);
//            bicycle.setProducer("Belarus");
//            LocationDaoImpl locationDao = new LocationDaoImpl();
//            Location location = new Location();
//            location = locationDao.read(2);
//            bicycle.setCurrentLocation(location);
//            PriceDaoImpl priceDao = new PriceDaoImpl();
//            Price price = new Price();
//            price = priceDao.read(1);
//            bicycle.setPrice(price);
//            bicycle.setIfNotBooked(true);
//            bicycle.setIfFree(true);
//            Bicycle bicycleD = new Bicycle();
//            bicycleD = bicycleDao.read(1);
//            bicycle.setPhoto(bicycleD.getPhoto());
//            bicycleDao.create(bicycle);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование поиска bicycle по Location
//        BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//        try {
//            BicycleDaoImpl bicycleDao1 = new BicycleDaoImpl();
//            LocationDaoImpl locationDao = new LocationDaoImpl();
//            Location location = new Location();
//            location = locationDao.read(3);
//            List<Bicycle> bicycleList = new ArrayList<>();
//            bicycleList = bicycleDao.readByCurrentLocation(location);
//            for (Bicycle bicycle: bicycleList) {
//            System.out.print(bicycle.toString());
//        }
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование  update bicycle
//        BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle.setId(21);
//            bicycle.setModel("BY-99999");
//            bicycle.setBicycleType(BicycleType.UNIVERSAL);
//            Short year = 2018;
//            bicycle.setProductionYear(year);
//            bicycle.setProducer("Belarus");
//            LocationDaoImpl locationDao = new LocationDaoImpl();
//            Location location = new Location();
//            location = locationDao.read(2);
//            bicycle.setCurrentLocation(location);
//            PriceDaoImpl priceDao = new PriceDaoImpl();
//            Price price = new Price();
//            price = priceDao.read(1);
//            bicycle.setPrice(price);
//            bicycle.setIfNotBooked(true);
//            bicycle.setIfFree(true);
//            Bicycle bicycleD = new Bicycle();
//            bicycleD = bicycleDao.read(1);
//            bicycle.setPhoto(bicycleD.getPhoto());
//            BicycleDaoImpl bicycleDao1 = new BicycleDaoImpl();
//            bicycleDao1.update(bicycle);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование delete Bicycle
//        BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//        try {
//            bicycleDao.delete(21);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
        // Тестирование создания userInfo
        //Справочно:
        // java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
        //LocalDate localDate = sqlDate.toLocalDate();
//        UserInfoDaoImpl userInfo = new UserInfoDaoImpl();
//        try {
//            UserInfo userInfoTest = new UserInfo();
//            userInfoTest.setSurname("Svet");
//            userInfoTest.setName("Marina");
//            userInfoTest.setSecondName("Vladislavovna");
//            LocalDate dateOfBirth = LocalDate.of( 1979, 1, 10);
//            userInfoTest.setBirthDate(dateOfBirth);
//            LocalDate dateOfPassport = LocalDate.of( 1980, 2, 11);
//            userInfoTest.setPassportIssueDate(dateOfPassport);
//            userInfoTest.setCountry(Country.BELARUS);
//            userInfoTest.setPassportIssuingAuthority("Centralnoje ROVD");
//            userInfoTest.setPassportIdentificationNumber("71555HH001PK3");
//            userInfoTest.setPassportSerialNumber("MP1234589");
//            userInfoTest.setPassportAddressRegistration("Minsk, Esenina, 127-3");
//            userInfoTest.setPassportAddressResidence("Minsk, Esenina, 127-3");
//            userInfoTest.setPhoneNumber(80297885858L);
//            userInfoTest.setSecondPhoneNumber(80177855858L);
//            userInfoTest.setEmail("leto@yandex.ru");
//            userInfo.create(userInfoTest);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
        ////------------------------------------------------------------------------------------------------------------
        // Тестирование update userInfo
        //Справочно:
        // java.sql.Date sqlDate = java.sql.Date.valueOf( todayLocalDate );
        //LocalDate localDate = sqlDate.toLocalDate();
//        UserInfoDaoImpl userInfo = new UserInfoDaoImpl();
//        try {
//            UserInfo userInfoTest = new UserInfo();
//            userInfoTest.setId(6);
//            userInfoTest.setSurname("Svet");
//            userInfoTest.setName("Marina");
//            userInfoTest.setSecondName("Vladislavovna");
//            LocalDate dateOfBirth = LocalDate.of( 1977, 1, 10);
//            userInfoTest.setBirthDate(dateOfBirth);
//            LocalDate dateOfPassport = LocalDate.of( 1980, 2, 11);
//            userInfoTest.setPassportIssueDate(dateOfPassport);
//            userInfoTest.setCountry(Country.BELARUS);
//            userInfoTest.setPassportIssuingAuthority("Centralnoje ROVD");
//            userInfoTest.setPassportIdentificationNumber("71555HH001PK3");
//            userInfoTest.setPassportSerialNumber("MP1234589");
//            userInfoTest.setPassportAddressRegistration("Minsk, Esenina, 127-3");
//            userInfoTest.setPassportAddressResidence("Minsk, Esenina, 127-3");
//            userInfoTest.setPhoneNumber(80297885858L);
//            userInfoTest.setSecondPhoneNumber(80177855858L);
//            userInfoTest.setEmail("leto@yandex.ru");
//            userInfo.update(userInfoTest);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
// Тестирование update userInfo
//        RentDaoImpl rentDao = new RentDaoImpl();
//        try {
//            Rent rent = new Rent();
//            rent.setStartTime(LocalDateTime.now());
//            User user = new User();
//            UserDaoImpl userDao = new UserDaoImpl();
//            user = userDao.read(2);
//            Bicycle bicycle = new Bicycle();
//            BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//            bicycle = bicycleDao.read(2);
//            rent.setUser(user);
//            rent.setBicycle(bicycle);
//            rentDao.create(rent);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
//// Тестирование rent: readByUserId
////        RentDaoImpl rentDao = new RentDaoImpl();
////        try {
////            List<Rent>rentList = new ArrayList<>();
////            rentList = rentDao.readByUserId(2);
////            for (Rent rent : rentList) {
////            System.out.print(rent.toString());
////        }
////        } catch (PersistentException e){
////                e.printStackTrace();
////
////       }
        ////------------------------------------------------------------------------------------------------------------
// Тестирование rent: readByBicycle
//        RentDaoImpl rentDao = new RentDaoImpl();
//        try {
//            Rent rent = new Rent();
//            Bicycle bicycle = new Bicycle();
//            BicycleDaoImpl bicycleDao = new BicycleDaoImpl();
//            bicycle = bicycleDao.read(4);
//            rent = rentDao.readByBicycle(bicycle);
//            System.out.print(rent.toString());
//        } catch (PersistentException e){
//                e.printStackTrace();
//
//       }
    }
}


