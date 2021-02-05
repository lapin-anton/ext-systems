package ru.java_project.ext.domain;

import java.time.LocalDate;

public class Passport {
    private Long passportId;
    private String seria;
    private String number;
    private LocalDate issueDate;
    private String issueDepartment;

    public Long getPassportId() {
        return passportId;
    }

    public String getSeria() {
        return seria;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
