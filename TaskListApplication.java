import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApplication {
    private ArrayList<String> taskList;
    private Scanner scanner;

    public TaskListApplication() {
        this.taskList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Step 1: Initialization

    // Method to add a task to the task list
    public void addTask(String task) {
        taskList.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to remove a task from the task list
    public void removeTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            String removedTask = taskList.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index. Task not removed.");
        }
    }

    // Method to list all tasks in the task list
    public void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    // Step 2: User Interface

    // Method to display menu options and handle user input
    public void displayMenu() {
        while (true) {
            System.out.println("\nTask List Application Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    addTask(newTask);
                    break;

                case 2:
                    System.out.print("Enter task index to remove: ");
                    int removeIndex = scanner.nextInt();
                    removeTask(removeIndex - 1); // Adjust index for user readability
                    break;

                case 3:
                    listTasks();
                    break;

                case 4:
                    System.out.println("Exiting Task List Application. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    public static void main(String[] args) {
        TaskListApplication taskListApp = new TaskListApplication();
        taskListApp.displayMenu();
    }
}
