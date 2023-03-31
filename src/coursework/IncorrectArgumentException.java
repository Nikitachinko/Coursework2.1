package coursework;

public class IncorrectArgumentException extends RuntimeException {
    private final String argument;

    public IncorrectArgumentException(String argument) {
        super();
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "Ввод данных некорректен!\n";
    }
}
