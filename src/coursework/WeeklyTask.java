package coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, String description, LocalDateTime dateTime) {
        super(title, type, dateTime , description);
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return getDateTime().getDayOfWeek().equals(dateTime.getDayOfWeek());
    }

    @Override
    public LocalDate getNextDate(LocalDateTime dateTime) {
        LocalDate localDate = dateTime.toLocalDate();
        return localDate.plusDays(7);
    }

    @Override
    public String toString() {
        return super.toString() + "\n повторять еженедельно";
    }
}
