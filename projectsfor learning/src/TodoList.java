import java.util.Scanner;
import java.util.ArrayList;
public class TodoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Todo List Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsDone();
                    break;
                case 4:
                    System.out.println("goodbye");
                    return;
                default:
                    System.out.println(" Invalid choice. Please try again ");
            }
        }
    }

    private static void addTask() {
        System.out.println(" what task description you want ");
        String task=scanner.nextLine();
        if (task.trim().isEmpty()) {
            System.out.println("Task cannot be empty!");
            return;
        }
        tasks.add(task);
        System.out.println("Task added successfully!"+ tasks.size());
    }
    private static void viewTasks() {
        System.out.println(" what task you want to see ");
        if (tasks.isEmpty()){
            System.out.println("no task to see ");
            return;
        }
         System.out.println("\n=== Your Tasks ===");
         for (int i=0;i<tasks.size();i++){
             System.out.println(i+1+"." +tasks.get(i));

        }

    }
    private static void markTaskAsDone() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark as done!");
            return;
        }
        viewTasks();
        System.out.println("which  tasks want mark as done!");
        int t=scanner.nextInt();
        scanner.nextLine();
        if(t>=1&&t<=tasks.size()){
            String removedTask = tasks.remove(t - 1);
            System.out.println("Marked as done ");
            System.out.println("removed: " + removedTask);
        }
        else {
            System.out.println("Invalid task number!");
        }
    }
}


