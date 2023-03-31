package coursework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();

        Scanner scanner = new Scanner(System.in);
        getMenu();

        while (scanner.hasNextLine()) {
            String menu = scanner.nextLine();
            switch (menu) {
                case "1":
                    // добавить новую задачу
                    taskService.addTask(getRegularity(getTaskTitle(), getTaskDescription(), getTaskType(), LocalDateTime.now()));
                    getMenu();
                    break;
                case "2":
                    // вывести список всех задач
                    System.out.println("Список всех задач");
                    try {
                        taskService.printAllTasks(taskService.getTaskMap());
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    getMenu();
                    break;
                case "3":
                    // удалить задачу
                    System.out.println("Введите id номер задачи, которую нужно удалить: ");
                    int taskId = scanner.nextInt();
                    try {
                        taskService.removeTask(taskId);
                        System.out.println("Задача удалена.");
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    getMenu();
                    scanner.nextLine();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод! Введите значение, указанное в меню (цифры от 1 до 4)");
                    getMenu();
            }
        }
        scanner.close();
    }

    // Метод для считывания названия задачи из консоли
    public static String getTaskTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи: ");
        try {
            String argument = scanner.nextLine();
            checkArgument(argument);
            return argument;
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getTaskTitle();
        }
    }

    // Метод для считывания описания задачи из консоли
    public static String getTaskDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите описание задачи: ");
        try {
            String argument = scanner.nextLine();
            checkArgument(argument);
            return argument;
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getTaskDescription();
        }
    }

    // Метод для считывания типа задачи из консоли
    public static Type getTaskType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип задачи (1 - рабочая, 2 - личная): ");
        String typeValue = scanner.nextLine();
        try {
            checkArgument(typeValue);
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getTaskType();
        }
        switch (typeValue) {
            case "1":
                return Type.WORK;
            case "2":
                return Type.PERSONAL;
            default:
                System.out.println("Тип задачи выбран не верно.");
                return getTaskType();
        }
    }

    // Метод для считывания регулярности выполнения задачи из консоли
    public static Task getRegularity(String title, String description, Type type, LocalDateTime localDateTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите повторяемость задачи (1 - однократно, 2 - ежедневно, 3 - еженедельно, 4 - ежемесячно, 5 - ежегодно): ");
        String period = scanner.nextLine();
        try {
            checkArgument(period);
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getRegularity(title, description, type, localDateTime);
        }
        switch (period) {
            case "1":
                System.out.println("Введите дату в формате ГГГГ-ММ-ДД: ");
                String date = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(date);
                return new OneTimeTask(title,type, description, LocalDateTime.now(),localDate);
            case "2":
                return new DailyTask(title,type, description,LocalDateTime.now());
            case "3":
                return new WeeklyTask(title,type, description,LocalDateTime.now());
            case "4":
                return new MonthlyTask(title,type, description,LocalDateTime.now());
            case "5":
                return new YearlyTask(title,type, description,LocalDateTime.now());
            default:
                System.out.println("Ошибка ввода! Введите значение, указанное в меню (цифры от 1 до 5)");
                return getRegularity(title, description, type, localDateTime);
        }
    }

    // Метод для вывода меню в консоль
    public static void getMenu() {
        System.out.println("\n Выберите: " +
                "\n 1 - добавить новую задачу: " +
                "\n 2 - вывести список всех задач:" +
                "\n 3 - удалить задачу: " +
                "\n 4 - выйти \n");
    }

    // Блок проверки вводимых значений
    public static void checkArgument(String argument) {
        if (argument.isEmpty() || argument.isBlank()) {
            throw new IncorrectArgumentException(argument);
        }
    }

    }

