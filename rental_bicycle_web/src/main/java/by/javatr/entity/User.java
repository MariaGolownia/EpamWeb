package by.javatr.entity;
import java.util.ArrayList;
import java.util.List;

public class User extends Entity {
    private String login;
    private String password;
    private Role role;
    private List<VirtualCard> virtualCardList = new ArrayList<>();
    private List<Rent> rentList = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<VirtualCard> getVirtualCardList() {
        return virtualCardList;
    }

    public void setVirtualCardList(List<VirtualCard> virtualCardList) {
        this.virtualCardList = virtualCardList;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", virtualCardList=" + virtualCardList +
                ", rentList=" + rentList +
                "}\n";
    }
}
