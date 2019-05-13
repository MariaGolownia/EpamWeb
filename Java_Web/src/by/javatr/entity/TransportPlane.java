package by.javatr.entity;
import java.util.Optional;

public class TransportPlane extends Plane implements PlaneInterface {
    private Optional<Integer> volumeOfCargoCompartmentCubicMeter;         // Объём грузового отсека транспортного самолёта
    private Optional<Integer> areaOfCargoHatchSquareMeter;                 // Площадь грузового люка транспортного самолёта

    public static TransportPlaneFactory factory = new TransportPlaneFactory() {
        @Override
        public TransportPlane getTransportPlane() {
            return new TransportPlane();
        }

        @Override
        public TransportPlane getTransportPlane(String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                              String manufacturingCompany, Integer seatingCapacityUnit, Integer carryingCapacityKilo,
                              Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo, Integer hoursOfFlightsHours,
                              Integer volumeOfCargoCompartmentCubicMeter, Integer areaOfCargoHatchSquareMeter) {
            return new TransportPlane(modelOfPlane, typeOfPlane, yearOfProduction, producingCountry,
                    manufacturingCompany, seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour,
                    emptyWeightKilo, hoursOfFlightsHours, volumeOfCargoCompartmentCubicMeter, areaOfCargoHatchSquareMeter);
        }
    };

    private TransportPlane() {
        super();
        volumeOfCargoCompartmentCubicMeter = Optional.of(0);
        areaOfCargoHatchSquareMeter = Optional.of(0);
    }

    private TransportPlane(String modelOfPlane, String typeOfPlane, Integer yearOfProduction, String producingCountry,
                          String manufacturingCompany, Integer seatingCapacityUnit,
                          Integer carryingCapacityKilo, Integer fuelConsumptionKiloPerHour, Integer emptyWeightKilo,
                          Integer hoursOfFlightsHours, Integer volumeOfCargoCompartmentCubicMeter,
                          Integer areaOfCargoHatchSquareMeter) {
        super(modelOfPlane, typeOfPlane, yearOfProduction, producingCountry, manufacturingCompany, seatingCapacityUnit, carryingCapacityKilo, fuelConsumptionKiloPerHour, emptyWeightKilo, hoursOfFlightsHours);
        setVolumeOfCargoCompartmentCubicMeter(volumeOfCargoCompartmentCubicMeter);
        setAreaOfCargoHatchSquareMeter(areaOfCargoHatchSquareMeter);
    }

    public void setVolumeOfCargoCompartmentCubicMeter(Integer volumeOfCargoCompartmentCubicMeter) {
        this.volumeOfCargoCompartmentCubicMeter = Optional.ofNullable(volumeOfCargoCompartmentCubicMeter);
        if (!this.volumeOfCargoCompartmentCubicMeter.isPresent())
            System.out.println("Warning: not a valid value (null)!" +
                    "'VolumeOfCargoCompartmentCubicMeter' parameter must be filled!");
    }

    public void setAreaOfCargoHatchSquareMeter(Integer areaOfCargoHatchSquareMeter) {
        this.areaOfCargoHatchSquareMeter = Optional.ofNullable(areaOfCargoHatchSquareMeter);
        if (!this.areaOfCargoHatchSquareMeter.isPresent())
            System.out.println("Warning: not a valid value (null)!" +
                    "'AreaOfCargoHatchSquareMeter' parameter must be filled!");
    }

    public Integer getVolumeOfCargoCompartmentCubicMeter() {
        return volumeOfCargoCompartmentCubicMeter.get();
    }

    public Integer getAreaOfCargoHatchSquareMeter() {
        return areaOfCargoHatchSquareMeter.get();
    }

    @Override
    public String toString() {
        return super.toString() +
                " volumeOfCargoCompartmentCubicMeter=" + volumeOfCargoCompartmentCubicMeter +
                ",\n areaOfCargoHatchSquareMeter=" + areaOfCargoHatchSquareMeter +
                "}";
    }
}
