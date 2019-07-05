package by.javatr.entity;

public enum Country {
    BELARUS("Belarus"),
    POLAND("Poland"),
    LITHUANIA("Lithuania");

    private String name;

    private Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIdentity() {
        return ordinal();
    }

    public static Country getByIdentity(Integer identity) {
        return Country.values()[identity];
    }
}
