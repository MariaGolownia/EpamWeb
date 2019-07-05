package by.javatr.entity;

public enum BicycleType {
    UNIVERSAL("universal"),
    HIGHWAY("highway"),
    HIGHLAND("highland");

    private String name;

    private BicycleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdentity() {
        return ordinal();
    }

    public static BicycleType getByIdentity(Integer identity) {
        return BicycleType.values()[identity];
    }
}
