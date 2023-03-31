package coursework;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return "Задач на сегодня нет \n";
    }

}
