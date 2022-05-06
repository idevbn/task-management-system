package com.idevbn.taskmanagementsystem.entities.enums;

import java.security.InvalidParameterException;

public enum TaskPriority {

    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private int code;

    private TaskPriority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskPriority valueOf(int code) {
        for (TaskPriority value : TaskPriority.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskPriority code");
    }
}
