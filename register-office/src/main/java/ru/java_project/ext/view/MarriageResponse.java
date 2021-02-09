package ru.java_project.ext.view;

import java.io.Serializable;

public class MarriageResponse implements Serializable {
    private boolean existing;

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }
}
