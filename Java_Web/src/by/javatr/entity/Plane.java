package by.javatr.entity;
import by.javatr.exc.*;
import by.javatr.print.PrintToConsole;
import by.javatr.util.IDAssignment;
import by.javatr.valid.ValidationIfPositive;
import by.javatr.valid.ValidationPlane;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Plane implements Comparable<Plane>, PlaneInterface {
    private static Logger LOGGER = Logger.getLogger(Plane.class);
    private Integer IDOfPlane;
    private static  List<Integer> listOdID = new ArrayList<>();
    private Optional<String> modelOfPlane;
    private Optional<String> typeOfPlane;
    private Optional<Integer> yearOfProduction;
    private Optional<String> producingCountry;
    private Optional<String> manufacturingCompany;
    private Optional<Integer> seatingCapacityUnit;          // Вместимость
    private Optional<Integer> carryingCapacityKilo;         // Грузоподъемность
    private Optional<Integer> fuelConsumptionKiloPerHour;   // Потребление горючего
    private Optional<Integer> emptyWeightKilo;              // Масса пустого самолета
    private Optional<Integer> hoursOfFlightsHours;          // Часы налетов


    public static PlaneFactory factory = new PlaneFactory() {
        @Override
        public Plane getPlane() {
            LOGGER.debug("Start getPlane");
            return new Plane();
        }

        @Override
        public Plane getPlane(Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction,
                              String producingCountry, String manufacturingCompany, Integer seatingCapacityUnit,
                              Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                              Integer hoursOfFlightsHours) {
            LOGGER.debug("Start getPlane");
            return new Plane (IDOfPlane, modelOfPlane, typeOfPlane, yearOfProduction, producingCountry, manufacturingCompany,
                    seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo,
                    hoursOfFlightsHours);
        }
    };


    protected Plane() {
        LOGGER.debug("Start Plane()");
        this.IDOfPlane = IDAssignment.assignForPlane(this.listOdID, 1);
        listOdID.add(this.IDOfPlane);
        this.modelOfPlane = Optional.of("No set");
        this.typeOfPlane = Optional.of("not defined");
        this.yearOfProduction = Optional.of(2019);
        this.producingCountry = Optional.of("USA");
        this.manufacturingCompany = Optional.of("No set");
        this.seatingCapacityUnit = Optional.of(2);
        this.carryingCapacityKilo = Optional.of(100);
        this.fuelConsumptionKiloPerHour = Optional.of(100);
        this.emptyWeightKilo = Optional.of(100);
        this.hoursOfFlightsHours = Optional.of(1);
    }

    protected Plane(Integer IDOfPlane, String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                 String manufacturingCompany, Integer seatingCapacityUnit, Integer carryingCapacityKilo,
                 Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo, Integer hoursOfFlightsHours) {
        LOGGER.debug("Start Plane() with parameters");
        setIDOfPlane(IDOfPlane);
        listOdID.add(this.IDOfPlane);
        setModelOfPlane(modelOfPlane);
        setTypeOfPlane(typeOfPlane);
        setYearOfProduction(yearOfProduction);
        setProducingCountry(producingCountry);
        setManufacturingCompany(manufacturingCompany);
        setSeatingCapacityUnit(seatingCapacityUnit);
        setCarryingCapacityKilo(carryingCapacityKilo);
        setFuelConsumptionKiloPerHour(fuelConsumptionKiloPerHour);
        setEmptyWeightKilo(emptyWeightKilo);
        setHoursOfFlightsHours(hoursOfFlightsHours);

    }

    public void setIDOfPlane(Integer idOfPlane) {
        try {
            if (ValidationPlane.ifCorrectIDOfPlane(idOfPlane, this.listOdID)) {
                this.IDOfPlane = IDAssignment.assignForPlane(listOdID, idOfPlane);
                listOdID.add(idOfPlane);
            }
            else{
                throw new ValidationException("Error: Check the correctness of idOfPlane (" + idOfPlane + ")!");
            }
        }
        catch(ValidationException ex) {
            LOGGER.error(ex.getMessage());
            PrintToConsole.println(ex.getMessage());
        }
    }

    protected void setIDOfPlaneOfAirline(Integer idOfPlane) {
                this.IDOfPlane = idOfPlane;
        }


    public void setModelOfPlane(String modelOfPlane) {
        try {
            if (ValidationPlane.ifCorrectModel(modelOfPlane)) {
                this.modelOfPlane = Optional.ofNullable(modelOfPlane);
                ValidationPlane.ifPresentString(this.modelOfPlane);
            }
            else{
            throw new NotCorrectModelException("Error: Check the correctness of modelOfPlane (" + modelOfPlane + ")!");
        }
        }
        catch(NotCorrectModelException ex) {
            LOGGER.error(ex.getMessage());
            PrintToConsole.println(ex.getMessage());
        }
    }

    public void setTypeOfPlane(String typeOfPlane) {
        try {
            if (ValidationPlane.ifCorrectType(typeOfPlane)) {
                this.typeOfPlane = Optional.ofNullable(typeOfPlane);
                ValidationPlane.ifPresentString(this.typeOfPlane);
            }
            else{
                throw new NotCorrectTypeException("Error: Check the correctness of typeOfPlane (" + typeOfPlane + ")!");
            }
        }
        catch(NotCorrectTypeException ex) {
            LOGGER.error(ex.getMessage());
            PrintToConsole.println(ex.getMessage());
        }
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        try {
            if (ValidationPlane.ifCorrectYear(yearOfProduction)) {
                this.yearOfProduction = Optional.ofNullable(yearOfProduction);
                ValidationPlane.ifPresentInteger(this.yearOfProduction);
            }
            else {
                throw new NotCorrectYearException("Error: Check the correctness of yearOfProduction (" + yearOfProduction + ")!");
            }
        }
        catch(NotCorrectYearException ex) {
            LOGGER.error(ex.getMessage());
            PrintToConsole.println(ex.getMessage());
        }
    }

    public void setProducingCountry(String producingCountry) {
        try {
            if (ValidationPlane.ifCorrectCountry(producingCountry)) {
                this.producingCountry = Optional.ofNullable(producingCountry);
                ValidationPlane.ifPresentString(this.producingCountry);
            }
            else {
                throw new NotCorrectCountryException("Error: Check the correctness of producingCountry ("
                        + producingCountry + ")!");
            }
        }
        catch(NotCorrectCountryException ex) {
            PrintToConsole.println(ex.getMessage());
        }

    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = Optional.ofNullable(manufacturingCompany);
        ValidationPlane.ifPresentString(this.manufacturingCompany);
    }

    public void setSeatingCapacityUnit(Integer seatingCapacityUnit) {
        try {
            if (ValidationIfPositive.ifPositiveNumber(seatingCapacityUnit)) {
                this.seatingCapacityUnit = Optional.ofNullable(seatingCapacityUnit);
                ValidationPlane.ifPresentInteger(this.seatingCapacityUnit);
            }
            else {
                throw new ValidationException("Error: Check the correctness of seatingCapacityUnit (" + seatingCapacityUnit + ")!");
            }
        }
        catch(ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
    }


   public void setCarryingCapacityKilo(Integer carryingCapacityKilo) {
        try {
            if (ValidationIfPositive.ifPositiveNumber(carryingCapacityKilo)) {
                this.carryingCapacityKilo = Optional.ofNullable(carryingCapacityKilo);
                ValidationPlane.ifPresentInteger(this.carryingCapacityKilo);
            }
            else {
                throw new ValidationException("Error: Check the correctness of carryingCapacityKilo (" + carryingCapacityKilo + ")!");
            }
        }
        catch(ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
    }


    public void setFuelConsumptionKiloPerHour(Integer fuelConsumptionKiloPerHour) {
        try {
            if (ValidationIfPositive.ifPositiveNumber(fuelConsumptionKiloPerHour)) {
                this.fuelConsumptionKiloPerHour = Optional.ofNullable(fuelConsumptionKiloPerHour);
                ValidationPlane.ifPresentInteger(this.fuelConsumptionKiloPerHour);
            }
            else {
                throw new ValidationException("Error: Check the correctness of fuelConsumptionKiloPerHour (" + fuelConsumptionKiloPerHour + ")!");
            }
        }
        catch(ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
    }

    public void setEmptyWeightKilo(Integer emptyWeightKilo) {
        try {
            if (ValidationIfPositive.ifPositiveNumber(emptyWeightKilo)) {
                this.emptyWeightKilo = Optional.ofNullable(emptyWeightKilo);
                ValidationPlane.ifPresentInteger(this.emptyWeightKilo);
            }
            else {
                throw new ValidationException("Error: Check the correctness of emptyWeightKilo (" + emptyWeightKilo + ")!");
            }
        }
        catch(ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
    }


    public void setHoursOfFlightsHours(Integer hoursOfFlightsHours) {
        try {
            if (ValidationIfPositive.ifPositiveNumber(hoursOfFlightsHours)) {
                this.hoursOfFlightsHours = Optional.ofNullable(hoursOfFlightsHours);
                ValidationPlane.ifPresentInteger(this.hoursOfFlightsHours);
            }
            else {
                throw new ValidationException("Error: Check the correctness of hoursOfFlightsHours (" + hoursOfFlightsHours + ")!");
            }
        }
        catch(ValidationException ex) {
            PrintToConsole.println(ex.getMessage());
        }
    }


    public Integer getIDOfPlane() {
        return IDOfPlane;
    }

    public String getModelOfPlane() {
        return modelOfPlane.get();
    }

    public String getTypeOfPlane() {
        return typeOfPlane.get();
    }

    public Integer getYearOfProduction() {
        return yearOfProduction.get();
    }

    public String getProducingCountry() {
         return producingCountry.get();
    }

    public String getManufacturingCompany() {
        return manufacturingCompany.get();
    }

    public Integer getSeatingCapacityUnit() {
        return seatingCapacityUnit.get();
    }

    public Integer getCarryingCapacityKilo() {
        return carryingCapacityKilo.get();
    }

    public Integer getFuelConsumptionKiloPerHour() {
        return fuelConsumptionKiloPerHour.get();
    }

    public Integer getEmptyWeightKilo() {
        return emptyWeightKilo.get();
    }

    public Integer getHoursOfFlightsHours() {
        return hoursOfFlightsHours.get();
    }

    @Override
    public String toString() {
        return "\n\n Plane {" +
                "\n IDOfPlane=" + IDOfPlane +
                ",\n modelOfPlane=" + modelOfPlane +
                ",\n typeOfPlane=" + typeOfPlane +
                ",\n yearOfProduction=" + yearOfProduction +
                ",\n producingCountry=" + producingCountry +
                ",\n manufacturingCompany=" + manufacturingCompany +
                ",\n seatingCapacityUnit=" + seatingCapacityUnit +
                ",\n carryingCapacityKilo=" + carryingCapacityKilo +
                ",\n fuelConsumptionKiloPerHour=" + fuelConsumptionKiloPerHour +
                ",\n emptyWeightKilo=" + emptyWeightKilo +
                ",\n hoursOfFlightsHours=" + hoursOfFlightsHours +
                ", \n";
    }

    @Override
    public int compareTo(Plane anotherPlane) {
        LOGGER.debug("Start compareTo");
        int result = this.getModelOfPlane().compareTo(anotherPlane.getModelOfPlane());
        LOGGER.debug("Start compareTo By getModelOfPlane. Result: result");
        if(result !=0) return result;

        result = this.getTypeOfPlane().compareTo(anotherPlane.getTypeOfPlane());
        LOGGER.debug("Start compareTo By getTypeOfPlane. Result: result");
        if(result !=0) return result;

        result= this.getYearOfProduction()- anotherPlane.getYearOfProduction();
        LOGGER.debug("Start compareTo By getYearOfProduction. Result: result");
        if(result !=0) return result;

        result=this.getProducingCountry().compareTo(anotherPlane.getProducingCountry());
        LOGGER.debug("Start compareTo By getProducingCountry. Result: result");
        if(result !=0) return result;

        result=this.getManufacturingCompany().compareTo(anotherPlane.getManufacturingCompany());
        LOGGER.debug("Start compareTo By getManufacturingCompany. Result: result");
        if(result !=0) return result;

        result= this.getSeatingCapacityUnit() - anotherPlane.getSeatingCapacityUnit();
        LOGGER.debug("Start compareTo By getSeatingCapacityUnit. Result: result");
        if(result !=0) return result;

        result= this.getCarryingCapacityKilo() - anotherPlane.getCarryingCapacityKilo();
        LOGGER.debug("Start compareTo By getCarryingCapacityKilo. Result: result");
        if(result !=0) return result;

        result= this.getFuelConsumptionKiloPerHour() - anotherPlane.getFuelConsumptionKiloPerHour();
        LOGGER.debug("Start compareTo By getFuelConsumptionKiloPerHour. Result: result");
        if(result !=0) return result;

        result= this.getEmptyWeightKilo() - anotherPlane.getEmptyWeightKilo();
        LOGGER.debug("Start compareTo By getEmptyWeightKilo. Result: result");
        if(result !=0) return result;

        result= this.getHoursOfFlightsHours() - anotherPlane.getHoursOfFlightsHours();
        return result;
    }


    public Object clone()     {
        Plane planeClone = new Plane();
        planeClone.IDOfPlane = this.getIDOfPlane();
        planeClone.setModelOfPlane(this.getModelOfPlane().toString());
        planeClone.setTypeOfPlane(this.getTypeOfPlane().toString());
        planeClone.setProducingCountry(this.producingCountry.toString());
        planeClone.setManufacturingCompany(this.getManufacturingCompany().toString());
        planeClone.setSeatingCapacityUnit(Integer.parseInt(this.getSeatingCapacityUnit().toString()));
        planeClone.setCarryingCapacityKilo(Integer.parseInt(this.getCarryingCapacityKilo().toString()));
        planeClone.setFuelConsumptionKiloPerHour(Integer.parseInt(this.getFuelConsumptionKiloPerHour().toString()));
        planeClone.setEmptyWeightKilo(Integer.parseInt(this.getEmptyWeightKilo().toString()));
        planeClone.setHoursOfFlightsHours(Integer.parseInt(this.getHoursOfFlightsHours().toString()));
        return planeClone;
    }
}
