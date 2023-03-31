package coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class OneTimeTask extends Task{
    private LocalDate timeOfTask;
    public OneTimeTask(String title, Type type, String description, LocalDateTime dateTime, LocalDate timeOfTask) {
        super(title, type,  dateTime,description);

    }
    public LocalDate getTimeOfTask() {
        return timeOfTask;
    }

    public void setTimeOfTask(LocalDate timeOfTask) {
        this.timeOfTask = timeOfTask;
    }



    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return timeOfTask.equals(dateTime);
    }

    @Override
    public LocalDate getNextDate(LocalDateTime dateTime) {
        return timeOfTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OneTimeTask that = (OneTimeTask) o;
        return Objects.equals(timeOfTask, that.timeOfTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeOfTask);
    }

    @Override
    public String toString() {
        return super.toString() + "\n повторить однократно, Срок выполнения " + timeOfTask;
    }
}
