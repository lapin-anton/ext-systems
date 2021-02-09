package ru.java_project.ext.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ro_marriage_certificate")

@NamedQueries({
        @NamedQuery(name = "MarriageCertificate.findCertificate",
            query = "SELECT mc FROM MarriageCertificate mc INNER JOIN mc.husband h INNER JOIN mc.wife w" +
                " WHERE h.firstName = :husbandGivenname" +
                " AND h.lastName = :husbandSurname" +
                " AND h.patronymic = :husbandPatronymic" +
                " AND h.dateOfBirth = :husbandDateOfBirth" +
                " AND w.firstName = :wifeGivenname" +
                " AND w.lastName = :wifeSurname" +
                " AND w.patronymic = :wifePatronymic" +
                " AND w.dateOfBirth = :wifeDateOfBirth"),
        @NamedQuery(name = "MarriageCertificate.findByNum",
            query = "SELECT mc FROM MarriageCertificate mc WHERE mc.number = :number")
})

public class MarriageCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marriage_certificate_id")
    private Long marriageCertificateId;
    @Column(name = "number")
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonMale husband;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonFemale wife;
    @Column(name = "active")
    private boolean active;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Long getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(Long marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PersonMale getHusband() {
        return husband;
    }

    public void setHusband(PersonMale husband) {
        this.husband = husband;
    }

    public PersonFemale getWife() {
        return wife;
    }

    public void setWife(PersonFemale wife) {
        this.wife = wife;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "MarriageCertificate{" +
                "marriageCertificateId=" + marriageCertificateId +
                ", number='" + number + '\'' +
                ", issueDate=" + issueDate +
                ", husband=" + husband +
                ", wife=" + wife +
                ", active=" + active +
                ", endDate=" + endDate +
                '}';
    }
}
