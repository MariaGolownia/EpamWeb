package by.javatr.controller;
import by.javatr.dao.mysql.DaoSql;
import by.javatr.entity.DateConverter;
import by.javatr.entity.User;
import by.javatr.entity.UserInfo;
import by.javatr.entity.en_um.Role;
import by.javatr.entity.en_um.UserStatus;
import by.javatr.service.FactoryService;
import by.javatr.service.ServiceException;
import by.javatr.service.impl.UserInfoServiceImpl;
import by.javatr.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class Runner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Start runner");
//------------------------------------------------------------------------------------------------------------
// Тестирование ввода данных о user в БД
//        Dao dao = null;
//        User user1 = new User();
//        user1.setLogin("tera");
//        user1.setPassword("1111111111");
//        user1.setRole(Role.USER);
//        user1.setUserStatus(UserStatus.BLOCKED);
//        try {
//            dao = FactoryService.getInstance().get(DaoSql.UserDaoSql);
//            dao.create(user1);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения списка всех user из БД
//        try {
//           UserDao dao = (UserDao) FactoryService.getInstance().get(DaoSql.UserDaoSql);
//            List<User> userList = new ArrayList();
//            userList = dao.read();
//            for (User user:userList) {
//                System.out.print(user.toString());
//            }
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения  user по ID из БД
//        try {
//            Dao dao = FactoryService.getInstance().get(DaoSql.UserDaoSql);
//            User userTest = (User) dao.read(2);
//            System.out.print(userTest.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения user по login и password из БД
//        try {
//            Dao dao = FactoryService.getInstance().get(DaoSql.UserDaoSql);
//            UserDaoSql userDaoTest4 =
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        UserDaoSql userDaoTest4 = new UserDaoSql();
//        try {
//            User userTest = userDaoTest4.read("swallow", "swallow111");
//            System.out.print(userTest.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
//        // Тестирование получения update user
//        UserDaoSql userDaoTest5 = new UserDaoSql();
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
//        UserDaoSql userDaoTest5 = new UserDaoSql();
//        try {
//            userDaoTest5.delete(8);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получение Company by ID
//        CompanyDaoSql companyDao = new CompanyDaoSql();
//        try {
//            Company company = new Company();
//            company = companyDao.read(1);
//            System.out.print(company.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получение Company by AccountNumber
//        CompanyDaoSql companyDao = new CompanyDaoSql();
//        try {
//            Company company = new Company();
//            company = companyDao.readByAccountNumberOfPayer(192693197);
//            System.out.print(company.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }

//------------------------------------------------------------------------------------------------------------
        // Тестирование создания Company by AccountNumber
//        CompanyDaoSql companyDao = new CompanyDaoSql();
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
//        CompanyDaoSql companyDao = new CompanyDaoSql();
//        try {
//            companyDao.delete(5);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Location by ID
//        LocationDaoSql locationDao = new LocationDaoSql();
//        try {
//            Location location = new Location();
//            location = locationDao.read(1);
//            System.out.print(location.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Location by Company_ID
//        LocationDaoSql locationDao = new LocationDaoSql();
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
//        LocationDaoSql locationDao = new LocationDaoSql();
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
//        LocationDaoSql locationDao = new LocationDaoSql();
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
//        LocationDaoSql locationDao = new LocationDaoSql();
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
//        LocationDaoSql locationDao = new LocationDaoSql();
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
//        LocationDaoSql locationDao = new LocationDaoSql();
//        try {
//            locationDao.delete(18);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения Price by ID
//        PriceDaoSql priceDao = new PriceDaoSql();
//        try {
//            Price price = new Price();
//            price = priceDao.read(1);
//            System.out.print(price.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование получения всех Price By Currency
//        PriceDaoSql priceDao = new PriceDaoSql();
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
//        PriceDaoSql priceDao = new PriceDaoSql();
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
////    PriceDaoSql priceDao = new PriceDaoSql();
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
//        PriceDaoSql priceDao = new PriceDaoSql();
//        try {
//            priceDao.update(priceUpdate);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
        // Тестирование delete Price
//        PriceDaoSql priceDaoImpl = new PriceDaoSql();
//        try {
//            priceDaoImpl.delete(5);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
        // Тестирование получения bicycle by ID
//        BicycleDaoSql bicycleDao = new BicycleDaoSql();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle = bicycleDao.read(1);
//            System.out.print(bicycle.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }}
//------------------------------------------------------------------------------------------------------------
// Тестирование получения bicycle by ID
//        BicycleDaoSql bicycleDao = new BicycleDaoSql();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle = bicycleDao.read(1);
//            System.out.print(bicycle.toString());
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }}
//------------------------------------------------------------------------------------------------------------
        // Тестирование создания bicycle
//        BicycleDaoSql bicycleDao = new BicycleDaoSql();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle.setModel("BY-1456");
//            bicycle.setBicycleType(BicycleType.UNIVERSAL);
//            Short year = 2019;
//            bicycle.setProductionYear(year);
//            bicycle.setProducer("Belarus");
//            LocationDaoSql locationDao = new LocationDaoSql();
//            Location location = new Location();
//            location = locationDao.read(2);
//            bicycle.setCurrentLocation(location);
//            PriceDaoSql priceDao = new PriceDaoSql();
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
//        BicycleDaoSql bicycleDao = new BicycleDaoSql();
//        try {
//            BicycleDaoSql bicycleDao1 = new BicycleDaoSql();
//            LocationDaoSql locationDao = new LocationDaoSql();
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
//        BicycleDaoSql bicycleDao = new BicycleDaoSql();
//        try {
//            Bicycle bicycle = new Bicycle();
//            bicycle.setId(21);
//            bicycle.setModel("BY-99999");
//            bicycle.setBicycleType(BicycleType.UNIVERSAL);
//            Short year = 2018;
//            bicycle.setProductionYear(year);
//            bicycle.setProducer("Belarus");
//            LocationDaoSql locationDao = new LocationDaoSql();
//            Location location = new Location();
//            location = locationDao.read(2);
//            bicycle.setCurrentLocation(location);
//            PriceDaoSql priceDao = new PriceDaoSql();
//            Price price = new Price();
//            price = priceDao.read(1);
//            bicycle.setPrice(price);
//            bicycle.setIfNotBooked(true);
//            bicycle.setIfFree(true);
//            Bicycle bicycleD = new Bicycle();
//            bicycleD = bicycleDao.read(1);
//            bicycle.setPhoto(bicycleD.getPhoto());
//            BicycleDaoSql bicycleDao1 = new BicycleDaoSql();
//            bicycleDao1.update(bicycle);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//------------------------------------------------------------------------------------------------------------
        // Тестирование delete Bicycle
//        BicycleDaoSql bicycleDao = new BicycleDaoSql();
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
//        UserInfoDaoSql userInfo = new UserInfoDaoSql();
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
//        UserInfoDaoSql userInfo = new UserInfoDaoSql();
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
//        RentDaoSql rentDao = new RentDaoSql();
//        try {
//            Rent rent = new Rent();
//            rent.setStartTime(LocalDateTime.now());
//            User user = new User();
//            UserDaoSql userDao = new UserDaoSql();
//            user = userDao.read(2);
//            Bicycle bicycle = new Bicycle();
//            BicycleDaoSql bicycleDao = new BicycleDaoSql();
//            bicycle = bicycleDao.read(2);
//            rent.setUser(user);
//            rent.setBicycle(bicycle);
//            rentDao.create(rent);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
////------------------------------------------------------------------------------------------------------------
//// Тестирование rent: readByUserId
////        RentDaoSql rentDao = new RentDaoSql();
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
//        RentDaoSql rentDao = new RentDaoSql();
//        try {
//            Rent rent = new Rent();
//            Bicycle bicycle = new Bicycle();
//            BicycleDaoSql bicycleDao = new BicycleDaoSql();
//            bicycle = bicycleDao.read(4);
//            rent = rentDao.readByBicycle(bicycle);
//            System.out.print(rent.toString());
//        } catch (PersistentException e){
//                e.printStackTrace();
//
//       }

        //       FactoryService factoryService = FactoryService.getInstance();
//        UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
//        User user = userService.findByLoginAndPassword("admin", "12345fhedfhe");
//        System.out.print(user.toString());

//        FactoryService factoryService = FactoryService.getInstance();
//        UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
//        User userByLogin = userService.findByLogin("admin");
//        if (userByLogin == null)
//            System.out.print("11111111111111111111111111111111");
//        else
//            System.out.print("22222222222222222222222222222222");
//        FactoryService factoryService = FactoryService.getInstance();
//        UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
//        User userNew = new User();
//        userNew.setLogin("Maria");
//        userNew.setPassword("kdvm;kwgvlwjg");
//        userNew.setUserStatus(UserStatus.ACTIVE);
//        userNew.setRole(Role.USER);
//        try {
//            userService.save(userNew);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//
//            String date = "11-12-2010";
//        LocalDate localDate = DateConverter.converterDateFromString(date);
//        System.out.print(localDate);
        try {
            FactoryService factoryService = FactoryService.getInstance();
            UserServiceImpl userService = factoryService.get(DaoSql.UserDao);
            User userNew = new User();
            userNew.setLogin("Pol");
            userNew.setPassword("123456kjbjhgjyg");
            userNew.setUserStatus(UserStatus.ACTIVE);
            userNew.setRole(Role.USER);

            Integer id = userService.save(userNew);

            UserInfoServiceImpl userInfoService = factoryService.get(DaoSql.UserInfoDao);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setSurname("Tio");
            userInfo.setName("Pol");
            userInfo.setSecondName("Pol");
            userInfo.setCountry("Pol");
            userInfo.setPassportIssueDate(DateConverter.converterDateFromString("25-02-2010"));
            userInfo.setPassportSerialNumber("1");
            userInfo.setPassportIdentificationNumber("2");
            userInfo.setPassportIssuingAuthority("3");
            userInfo.setPassportAddressRegistration("4");
            userInfo.setPassportAddressResidence("5");
            userInfo.setPhoneNumber(6L);
            userInfo.setSecondPhoneNumber(7L);
            userInfo.setEmail("8");

            userInfoService.save(userInfo);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}


