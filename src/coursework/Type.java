package coursework;

public enum Type {
    WORK("Рабочая"),
    PERSONAL("Личная");

    private final String taskType;

    Type(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }
}
