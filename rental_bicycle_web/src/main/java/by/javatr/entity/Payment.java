package by.javatr.entity;

import java.math.BigDecimal;

public class Payment {
    private BigDecimal amount;
    private VirtualCard virtualCard;
    private Company company;
    private Boolean ifPaid;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public VirtualCard getVirtualCard() {
        return virtualCard;
    }

    public void setVirtualCard(VirtualCard virtualCard) {
        this.virtualCard = virtualCard;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getIfPaid() {
        return ifPaid;
    }

    public void setIfPaid(Boolean ifPaid) {
        this.ifPaid = ifPaid;
    }
}
