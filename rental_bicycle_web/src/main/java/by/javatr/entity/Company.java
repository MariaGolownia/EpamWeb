package by.javatr.entity;

public class Company extends Entity {
    private String name;
    private String accountNumberOfPayer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumberOfPayer() {
        return accountNumberOfPayer;
    }

    public void setAccountNumberOfPayer(String accountNumberOfPayer) {
        this.accountNumberOfPayer = accountNumberOfPayer;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", accountNumberOfPayer='" + accountNumberOfPayer + '\'' +
                '}';
    }
}
