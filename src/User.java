import java.util.ArrayList;
import java.util.List;

public class User {
    static int userAmount = 1;
    private final int userID;
    private String userName;
    private List<Task> userTasks;

    // Constructor
    public User(String userName) {
        this.userID = userAmount;
        userAmount++;
        this.userName = userName;
        this.userTasks = new ArrayList<>();
    }

    // Getters
    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }



    // Funções
    // Adicionar tarefa
    public void assignTask(Task targetTask){
        if (targetTask != null) {
            this.userTasks.add(targetTask);
            targetTask.addUser(this);
        } else {
            System.out.println("Tarefa inexistente.");
        }

    }

    // Remover tarefa
    public void removeTask(Task targetTask){
        if (this.userTasks.contains(targetTask)){
            this.userTasks.remove(targetTask);
            targetTask.removeUser(this);
        } else {
            System.out.println("Tarefa inexistente.");
        }
    }

    // Buscar por usuário em List<User>
    public static User searchUser(String searchQuery, List<User> searchLocale){
        return searchLocale.stream()
                .filter(user -> user.getUserName().matches(searchQuery))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return getUserName();
    }
}

