package by.javatr.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Rent extends Entity{
    private User user;
    private Bicycle bicycle;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
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

    @Override
    public String toString() {
        return "Rent{" +
                "user=" + user +
                ", bicycle=" + bicycle +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", finishLocation=" + finishLocation +
                ", payment=" + payment +
                '}';
    }
}
