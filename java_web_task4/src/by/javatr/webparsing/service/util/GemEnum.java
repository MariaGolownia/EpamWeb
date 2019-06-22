package by.javatr.webparsing.service.util;

public enum GemEnum {
    GEMS("gems"),
    GEM("gem"),
    NATURALGEM("naturalGem"),
    SYNTHETICGEM("syntheticGem"),
    ID("id"),
    PRECIOUSNESS("preciousness"),
    NAME("name"),
    VALUEGR("valueGr"),
    VISUALPARAMETERS("visualParameters"),
    COLOR("color"),
    TRANSPARENCYPR("transparencyPr"),
    FACESNUMBER("facesNumber"),
    ORIGINTREATMENT("originTreatment"),
    TREATER("treater"),
    DATETREATMENT("dateTreatment"),
    ORIGINEXTRACTION("originExtraction"),
    DATEEXTRACTION("dateExtraction"),
    MANUFACTURINGMETHOD("manufacturingMethod"),
    PROCESSINGMETHOD("processingMethod");

    private String value;
    private GemEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

