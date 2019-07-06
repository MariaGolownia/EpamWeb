package by.javatr.entity;
import java.util.Date;


public class Rent extends Entity{
    private User user;
    private Bicycle bicycle;
    private Date startTime;
    private Date finishTime;
    private Location finishLocation;
    private Payment payment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Location getFinishLocation() {
        return finishLocation;
    }

    public void setFinishLocation(Location finishLocation) {
        this.finishLocation = finishLocation;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
