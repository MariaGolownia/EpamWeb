package by.javatr.entity;
import java.util.Date;

public class UserInfo extends Entity {
    private String surname;
    private String name;
    private String secondName;
    private Date birthDate;
    private Date passportIssueDate;
    private String passportIssuingAuthority;
    private String passportIdentificationNumber;
    private String passportSerialNumber;
    private String passportAdressRegistration;
    private String passportAdressResidence;
    private Long phoneNumber;
    private Long secondPhoneNumber;
    private String email;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(Date passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getPassportIssuingAuthority() {
        return passportIssuingAuthority;
    }

    public void setPassportIssuingAuthority(String passportIssuingAuthority) {
        this.passportIssuingAuthority = passportIssuingAuthority;
    }

    public String getPassportIdentificationNumber() {
        return passportIdentificationNumber;
    }

    public void setPassportIdentificationNumber(String passportIdentificationNumber) {
        this.passportIdentificationNumber = passportIdentificationNumber;
    }

    public String getPassportSerialNumber() {
        return passportSerialNumber;
    }

    public void setPassportSerialNumber(String passportSerialNumber) {
        this.passportSerialNumber = passportSerialNumber;
    }

    public String getPassportAdressRegistration() {
        return passportAdressRegistration;
    }

    public void setPassportAdressRegistration(String passportAdressRegistration) {
        this.passportAdressRegistration = passportAdressRegistration;
    }

    public String getPassportAdressResidence() {
        return passportAdressResidence;
    }

    public void setPassportAdressResidence(String passportAdressResidence) {
        this.passportAdressResidence = passportAdressResidence;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(Long secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
