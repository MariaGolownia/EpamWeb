package by.javatr.entity;

public enum UserStatus {
    BLOCKED("Blocked"),
    ACTIVE("Active");

    private String name;

    private UserStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static UserStatus getById(Integer id) {
        return UserStatus.values()[id];
    }
}
