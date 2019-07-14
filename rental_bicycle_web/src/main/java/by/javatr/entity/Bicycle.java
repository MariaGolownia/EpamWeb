package by.javatr.entity;
import by.javatr.entity.en_um.BicycleType;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Bicycle extends Entity {
    private String model;
    private BicycleType bicycleType;
    private Short productionYear;
    private String producer;
    private Location currentLocation;
    private Blob photo;
    private Price price;
    private Boolean ifNotBooked;
    private Boolean ifFree;
    private List<Rent> rentList = new ArrayList<>();

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BicycleType getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(BicycleType bicycleType) {
        this.bicycleType = bicycleType;
    }

    public Short getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Short productionYear) {
        this.productionYear = productionYear;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public Boolean getIfNotBooked() {
        return ifNotBooked;
    }

    public Integer getIfNotBookedInt() {
        return ifNotBooked == true ? 1 : 0;
    }

    public void setIfNotBooked(Boolean ifNotBooked) {
        this.ifNotBooked = ifNotBooked;
    }

    public void setIfNotBooked(Integer ifNotBooked) {
        if (ifNotBooked == 1) {
        this.ifNotBooked = true;}
        else this.ifNotBooked = false;
    }

    public Boolean getIfFree() {
        return ifFree;
    }

    public Integer getIfFreeInt() {
        return ifFree == true ? 1 : 0;
    }

    public void setIfFree(Boolean ifFree) {
        this.ifFree = ifFree;
    }

    public void setIfFree(Integer ifFree) {
        if (ifFree == 1) {
            this.ifFree = true;}
        else this.ifFree = false;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "model='" + model + '\'' +
                ", bicycleType=" + bicycleType +
                ", productionYear=" + productionYear +
                ", producer='" + producer + '\'' +
                ", currentLocation=" + currentLocation +
                ", photo=" + photo +
                ", price=" + price +
                ", ifNotBooked=" + ifNotBooked +
                ", ifFree=" + ifFree +
                ", rentList=" + rentList +
                '}';
    }
}
