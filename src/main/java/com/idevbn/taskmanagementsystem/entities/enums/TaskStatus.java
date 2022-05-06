package com.idevbn.taskmanagementsystem.entities.enums;

public enum TaskStatus {

    PENDING(0),
    FINISHED(1);

    private int code;

    private TaskStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskStatus valueOf(int code) {
        for (TaskStatus value : TaskStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code");
    }
}

