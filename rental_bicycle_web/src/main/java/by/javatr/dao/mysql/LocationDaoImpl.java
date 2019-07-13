package by.javatr.dao.mysql;
import by.javatr.dao.LocationDao;
import by.javatr.dao.PersistentException;
import by.javatr.dao.pool.ConnectionSQL;
import by.javatr.entity.*;
import by.javatr.entity.valid.EntityValidation;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class LocationDaoImpl extends BaseDaoImpl implements LocationDao {
    private static final String SQL_SELECT_LOCATION_BY_ID =
            "SELECT `location_name`, `location_company_id`, `location_country`, `location_city`, `location_street`, " +
                    "`location_house`, `location_office`, `location_phone` , `location_secondPhone`, `location_photo`" +
                    " FROM `location` WHERE `location_id` = ?";
    private static final String SQL_SELECT_LOCATIONS_BY_COMPANY_ID =
            "SELECT `location_id`,`location_name`, `location_company_id`, `location_country`, `location_city`," +
                    "`location_street`, `location_house`, `location_office`, `location_phone` , `location_secondPhone`," +
                    " `location_photo` FROM `location` WHERE `location_company_id` = ?";
    private static final String SQL_SELECT_LOCATIONS_BY_COUNTRY =
            "SELECT `location_id`,`location_name`, `location_company_id`, `location_city`," +
                    "`location_street`, `location_house`, `location_office`, `location_phone` , `location_secondPhone`," +
                    " `location_photo` FROM `location` WHERE `location_country` = ?";
    private static final String SQL_SELECT_LOCATIONS_BY_CITY=
            "SELECT `location_id`,`location_name`, `location_company_id`, `location_country`," +
                    "`location_street`, `location_house`, `location_office`, `location_phone` , `location_secondPhone`," +
                    " `location_photo` FROM `location` WHERE `location_city` = ?";


    @Override
    public List<Location> readByCompanyId(Integer companyID) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_LOCATIONS_BY_COMPANY_ID);
            statement.setInt(1, companyID);
            resultSet = statement.executeQuery();
            Location location = null;
            List<Location> locationList = new ArrayList<>();
            while(resultSet.next()) {
                location = new Location();
                location.setId(resultSet.getInt("location_id"));
                location.setName(resultSet.getString("location_name"));
                Company company = new Company();
                CompanyDaoImpl companyDao = new CompanyDaoImpl();
                company = companyDao.read(resultSet.getInt("location_company_id"), connection);
                location.setCompany(company);
                String countryStr = resultSet.getString("location_country");
                Country country = Country.getCountry(countryStr);
                String cityStr = resultSet.getString("location_city");
                City city = City.getCity(cityStr);
                EntityValidation entityValidation = new EntityValidation();
                if (entityValidation.ifCityBelongsToCountry(country, city)) {
                    location.setCountry(country);
                    location.setCity(city);
                }
                else try {
                    throw new EntityException("Check the correctness of the country and city located in the country!");
                } catch (EntityException e) {
                    e.printStackTrace();
                }
                location.setStreet(resultSet.getString("location_street"));
                location.setHouse(resultSet.getString("location_house"));
                location.setOffice(resultSet.getString("location_office"));
                location.setPhone(resultSet.getLong("location_phone"));
                location.setSecondPhone(resultSet.getLong("location_secondPhone"));
                location.setPhoto(resultSet.getString("location_photo"));
                locationList.add(location);
            }
            return locationList;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<Location> readByCountry(String country) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_LOCATIONS_BY_COUNTRY);
            statement.setString(1, country);
            resultSet = statement.executeQuery();
            Location location = null;
            List<Location> locationList = new ArrayList<>();
            while(resultSet.next()) {
                location = new Location();
                location.setId(resultSet.getInt("location_id"));
                location.setName(resultSet.getString("location_name"));
                Company company = new Company();
                CompanyDaoImpl companyDao = new CompanyDaoImpl();
                company = companyDao.read(resultSet.getInt("location_company_id"), connection);
                location.setCompany(company);
                Country countryC = Country.getCountry(country);
                String cityStr = resultSet.getString("location_city");
                City city = City.getCity(cityStr);
                EntityValidation entityValidation = new EntityValidation();
                if (entityValidation.ifCityBelongsToCountry(countryC, city)) {
                    location.setCountry(countryC);
                    location.setCity(city);
                }
                else try {
                    throw new EntityException("Check the correctness of the country and city located in the country!");
                } catch (EntityException e) {
                    e.printStackTrace();
                }
                location.setStreet(resultSet.getString("location_street"));
                location.setHouse(resultSet.getString("location_house"));
                location.setOffice(resultSet.getString("location_office"));
                location.setPhone(resultSet.getLong("location_phone"));
                location.setSecondPhone(resultSet.getLong("location_secondPhone"));
                location.setPhoto(resultSet.getString("location_photo"));
                locationList.add(location);
            }
            return locationList;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public List<Location> readByCity(String city) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_LOCATIONS_BY_CITY);
            statement.setString(1, city);
            resultSet = statement.executeQuery();
            Location location = null;
            List<Location> locationList = new ArrayList<>();
            while(resultSet.next()) {
                location = new Location();
                location.setId(resultSet.getInt("location_id"));
                location.setName(resultSet.getString("location_name"));
                Company company = new Company();
                CompanyDaoImpl companyDao = new CompanyDaoImpl();
                company = companyDao.read(resultSet.getInt("location_company_id"), connection);
                location.setCompany(company);
                String countryStr = resultSet.getString("location_country");
                Country country = Country.getCountry(countryStr);
                EntityValidation entityValidation = new EntityValidation();
                City cityC = City.valueOf(city.toUpperCase());
                if (entityValidation.ifCityBelongsToCountry(country, cityC)) {
                    location.setCountry(country);
                    location.setCity(cityC);
                }
                else try {
                    throw new EntityException("Check the correctness of the country and city located in the country!");
                } catch (EntityException e) {
                    e.printStackTrace();
                }
                location.setStreet(resultSet.getString("location_street"));
                location.setHouse(resultSet.getString("location_house"));
                location.setOffice(resultSet.getString("location_office"));
                location.setPhone(resultSet.getLong("location_phone"));
                location.setSecondPhone(resultSet.getLong("location_secondPhone"));
                location.setPhoto(resultSet.getString("location_photo"));
                locationList.add(location);
            }
            return locationList;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public Integer create(Location entity) throws PersistentException {
        return null;
    }

    @Override
    public Location read(Integer id) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            ConnectionSQL connectionSQL = new ConnectionSQL();
            connection = connectionSQL.getConnectionToDB();
            statement = connection.prepareStatement(SQL_SELECT_LOCATION_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Location location = null;
            if(resultSet.next()) {
                location = new Location();
                location.setId(id);
                location.setName(resultSet.getString("location_name"));
                Company company = new Company();
                CompanyDaoImpl companyDao = new CompanyDaoImpl();
                company = companyDao.read(resultSet.getInt("location_company_id"), connection);
                location.setCompany(company);
                String countryStr = resultSet.getString("location_country");
                Country country = Country.getCountry(countryStr);
                String cityStr = resultSet.getString("location_city");
                City city = City.getCity(cityStr);
                EntityValidation entityValidation = new EntityValidation();
                if (entityValidation.ifCityBelongsToCountry(country, city)) {
                    location.setCountry(country);
                    location.setCity(city);
                }
                else try {
                    throw new EntityException("Check the correctness of the country and city located in the country!");
                } catch (EntityException e) {
                    e.printStackTrace();
                }
                location.setStreet(resultSet.getString("location_street"));
                location.setHouse(resultSet.getString("location_house"));
                location.setOffice(resultSet.getString("location_office"));
                location.setPhone(resultSet.getLong("location_phone"));
                location.setSecondPhone(resultSet.getLong("location_secondPhone"));
                location.setPhoto(resultSet.getString("location_photo"));
            }
            return location;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
                connection.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    public Location read(Integer id, Connection connection) throws PersistentException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_LOCATION_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Location location = null;
            if(resultSet.next()) {
                location = new Location();
                location.setId(id);
                location.setName(resultSet.getString("location_name"));
                Company company = new Company();
                CompanyDaoImpl companyDao = new CompanyDaoImpl();
                company = companyDao.read(resultSet.getInt("location_company_id"), connection);
                location.setCompany(company);
                String countryStr = resultSet.getString("location_country");
                Country country = Country.getCountry(countryStr);
                String cityStr = resultSet.getString("location_city");
                City city = City.getCity(cityStr);
                EntityValidation entityValidation = new EntityValidation();
                if (entityValidation.ifCityBelongsToCountry(country, city)) {
                    location.setCountry(country);
                    location.setCity(city);
                }
                else try {
                    throw new EntityException("Check the correctness of the country and city located in the country!");
                } catch (EntityException e) {
                    e.printStackTrace();
                }
                location.setStreet(resultSet.getString("location_street"));
                location.setHouse(resultSet.getString("location_house"));
                location.setOffice(resultSet.getString("location_office"));
                location.setPhone(resultSet.getLong("location_phone"));
                location.setSecondPhone(resultSet.getLong("location_secondPhone"));
                location.setPhoto(resultSet.getString("location_photo"));
            }
            return location;
        } catch(SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    @Override
    public void update(Location entity) throws PersistentException {

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }
}
