package ru.java_project.ext.domain;

public class PersonResponse {
    private boolean registered;
    private boolean temporal;

    public boolean isRegistered() {
        return registered;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "registered=" + registered +
                ", temporal=" + temporal +
                '}';
    }
}
