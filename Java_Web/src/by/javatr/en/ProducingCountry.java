package by.javatr.en;

public enum ProducingCountry {
    USA, BRAZIL, EUROPEAN_UNION;

    public String toString() {
        switch (this) {
            case USA:
                return "USA";
            case BRAZIL:
                return "BRAZIL";
            case EUROPEAN_UNION:
                return "EUROPEAN_UNION";
        }
        return null;
    }
}
