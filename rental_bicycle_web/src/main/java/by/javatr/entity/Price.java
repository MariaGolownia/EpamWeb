package by.javatr.entity;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class Price extends Entity {
    private Currency currency;
    private Date unitTime;
    private BigDecimal rate;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getUnitTime() {
        return unitTime;
    }

    public void setUnitTime(Date unitTime) {
        this.unitTime = unitTime;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
