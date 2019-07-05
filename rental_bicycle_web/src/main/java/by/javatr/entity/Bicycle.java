package by.javatr.entity;
import java.sql.Blob;
import java.time.Year;

public class Bicycle extends Entity {
    private String model;
    private BicycleType bicycleType;
    private Year productionYear;
    private String producer;
    private Blob photo;

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

    public Year getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Year productionYear) {
        this.productionYear = productionYear;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
}
