package by.javatr.entity;
import java.time.LocalDateTime;
import java.util.List;

public class Order extends Entity {
    private Integer userId;
    private List<Integer> bicyclesId;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private Location finishLocation;
    private Payment payment;
    String startTimeStr;
    String finishTimeStr;

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public String getFinishTimeStr() {
        return finishTimeStr;
    }

    public void setFinishTimeStr(String finishTimeStr) {
        this.finishTimeStr = finishTimeStr;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer idUser) {
        this.userId = idUser;
    }

    public List<Integer> getBicyclesId() {
        return bicyclesId;
    }

    public void setBicyclesId(List<Integer> idBicycles) {
        this.bicyclesId = idBicycles;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        this.startTimeStr = startTime.toString();
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
        this.finishTimeStr = finishTime.toString();
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
