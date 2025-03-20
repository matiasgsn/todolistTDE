import java.util.ArrayList;
import java.util.List;

public class Task {
    static int taskAmount = 1;
    private final int taskID;
    private String taskName;
    private String taskDescription;

    public List<User> taskAssignedUsers;

    // Constructor
    public Task(String taskName, String taskDescription) {
        this.taskID = taskAmount;
        taskAmount++;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskAssignedUsers = new ArrayList<>();
    }

    // Getters
    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public List<User> getTaskAssignedUsers() {
        return taskAssignedUsers;
    }

    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }



    // Functions
    // Auxiliares pra funções Assign e Remove de USER
    public void addUser(User user) {
        this.taskAssignedUsers.add(user);
    }

    public void removeUser(User user) {
        this.taskAssignedUsers.remove(user);
    }

    // Buscar por tarefa em List<Task>
    public static Task searchTask(String searchQuery, List<Task> searchLocale){
        return searchLocale.stream()
                .filter(task -> task.getTaskName().matches(searchQuery))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return getTaskName() + " : Tarefa Regular : " + getTaskDescription();
    }
}
