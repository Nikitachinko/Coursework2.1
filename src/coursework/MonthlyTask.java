package coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description, LocalDateTime dateTime) {
        super(title, type, dateTime,description );
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return getDateTime().getDayOfMonth() == dateTime.getDayOfMonth();
    }

    @Override
    public LocalDate getNextDate(LocalDateTime dateTime) {
        LocalDate localDate = dateTime.toLocalDate();
        return localDate.withMonth(getDateTime().getMonthValue() + 1);
    }

    @Override
    public String toString() {
        return super.toString() + "\n повторять ежемесячно";


    }
}
