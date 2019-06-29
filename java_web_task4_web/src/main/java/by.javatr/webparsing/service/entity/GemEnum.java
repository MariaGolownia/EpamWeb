package by.javatr.webparsing.service.entity;

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
    MANUFACTURINGMETHOD("manufacturingMehod"),
    PROCESSINGMETHOD("processingMethod");

    private String value;
    private GemEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}