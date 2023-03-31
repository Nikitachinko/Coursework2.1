package coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Task {
    private static int idGeneration;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) {
        this.title = title;
        this.type = type;
        this.id = ++idGeneration;
        this.dateTime = dateTime;
        this.description = description;
    }

    public static int getIdGeneration() {
        return idGeneration;
    }

    public static void setIdGeneration(int idGeneration) {
        Task.idGeneration = idGeneration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /*
     * Метод для проверки повторяемости задачи
     */
    public abstract boolean appearsIn(LocalDateTime dateTime);

    /*
     * Метод для получения следующей даты выподнения задачи
     */
    public  abstract LocalDate getNextDate(LocalDateTime dateTime);

    @Override
    public String toString() {
        return "id: " + id +
                "\n   Название задачи: " + title +
                "\n   Описание задачи: " + description +
                "\n   Тип задачи: " + type.getTaskType() +
                "\n   Дата и время создания задачи: " + dateTime;
    }


    public LocalDateTime installDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy MM dd] [HH:mm:ss]");
        String text = localDateTime.format(formatter);
        return LocalDateTime.parse(text, formatter);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && type == task.type && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, description);
    }

}
