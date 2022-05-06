package com.idevbn.taskmanagementsystem.entities.enums;

public enum TaskFrequency {

    DAILY(0),
    WEEKLY(1),
    MONTHLY(2);

    private int code;

    private TaskFrequency(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskFrequency valueOf(int code) {
        for (TaskFrequency value : TaskFrequency.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskFrequency code");
    }
}
