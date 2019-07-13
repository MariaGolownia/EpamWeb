package by.javatr.entity;

public enum TimeUnit {
    HOUR("hour"),
    MIN("min"),
    SEC("sec");


    private String name;

    private TimeUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static TimeUnit getById(Integer id) {
        return TimeUnit.values()[id];
    }

    public static TimeUnit getTimeUnit(String str) {
        TimeUnit timeUnit = null;
        for (int i = 0; i < TimeUnit.values().length; i++) {
            String timeUnitFromEnum = TimeUnit.values()[i].toString();
            if (timeUnitFromEnum.equals(str.toUpperCase())) {
                timeUnit = TimeUnit.getById(i);
            }
        }
        return timeUnit;
    }
}
