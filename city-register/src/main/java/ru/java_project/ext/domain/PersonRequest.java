package ru.java_project.ext.domain;

import java.time.LocalDate;

public class PersonRequest {
    private String surName;
    private String givenName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Integer districtCode;
    private Integer streetCode;
    private String building;
    private String extension;
    private String apartment;

    public String getSurName() {
        return surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public Integer getStreetCode() {
        return streetCode;
    }

    public String getBuilding() {
        return building;
    }

    public String getExtension() {
        return extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public void setStreetCode(Integer streetCode) {
        this.streetCode = streetCode;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
