public class SmallTask extends Task{
    public SmallTask(String taskName, String taskDescription) {
        super(taskName, taskDescription);
    }

    @Override
    public void addUser(User user) {
        if (taskAssignedUsers.size() >= 3) {
            throw new IllegalArgumentException("Máximo de membros atingido");
        }
        this.taskAssignedUsers.add(user);
    }

    public String toString() {
        return getTaskName() + " : Tarefa Pequena : " + getTaskDescription();
    }
}
