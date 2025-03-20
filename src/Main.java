import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var i = 0;
        List<User> userList = new ArrayList<>();
        List<Task> taskList = new ArrayList<>();

        User searchedUser = null;
        Task searchedTask = null;

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        while (i != 9){
            searchedUser = null;
            searchedTask = null;

            System.out.println("To do Manager");
            System.out.println("1. Criar usuário");
            System.out.println("2. Ver usuários");
            System.out.println("3. Ver tarefas de usuário");
            System.out.println("4. Criar tarefa");
            System.out.println("5. Ver tarefas");
            System.out.println("6. Ver usuários em tarefa");
            System.out.println("7. Adicionar usuário à tarefa");
            System.out.println("8. Remover usuário de tarefa");
            System.out.println("9. Sair do Programa");
            try{
                i = Integer.parseInt(input.next());
            } catch (NumberFormatException error){
                System.out.println("Opção inválida.");
                // input.nextLine();
            }

            switch (i) {
                case 1:
                    System.out.println("Criar novo usuário");
                    System.out.println("Insira o nome do usuário:");
                    userList.add(new User(input.next()));
                    break;

                case 2:
                    System.out.println("Usuários existentes:");
                    System.out.println(userList);
                    break;

                case 3:
                    System.out.println("Ver tarefas de usuário");
                    System.out.println("Insira o nome do usuário:");
                    searchedUser = User.searchUser(input.next(), userList);

                    if (searchedUser != null) {
                        System.out.println(searchedUser.getUserTasks());
                        break;
                    } else {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                case 4:
                    System.out.println("Criar nova tarefa");
                    System.out.println("Insira o nome da tarefa e sua descrição:");
                    String newTaskName = input.next();
                    String newTaskDescription = input.next();

                    System.out.println("Qual o tamanho da tarefa? (1 - Normal, 2 - Pequena)");
                    int escolha = 0;
                    try {
                        escolha = Integer.parseInt(input.next());
                    } catch (NumberFormatException error) {
                        System.out.println("Opção inválida.");
                    }

                    switch (escolha) {
                        case 1:
                            taskList.add(new Task(newTaskName, newTaskDescription));
                            break;

                        case 2:
                            taskList.add(new SmallTask(newTaskName, newTaskDescription));
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Tarefas existentes:");
                    System.out.println(taskList);
                    break;

                case 6:
                    System.out.println("Ver usuários em tarefa");
                    System.out.println("Insira o nome da tarefa:");
                    searchedTask = Task.searchTask(input.next(), taskList);

                    if (searchedTask != null) {
                        System.out.println(searchedTask.getTaskAssignedUsers());
                        break;
                    } else {
                        System.out.println("Tarefa não encontrada.");
                        break;
                    }

                case 7:
                    System.out.println("Adicionar usuário à tarefa");
                    System.out.println("Digite o nome da tarefa:");

                    searchedTask = Task.searchTask(input.next(), taskList);

                    if (searchedTask != null) {
                        System.out.println(searchedTask);
                        System.out.println("Digite o nome do usuário:");

                        searchedUser = User.searchUser(input.next(), userList);

                        if (searchedUser != null) {
                            try {
                                searchedUser.assignTask(searchedTask);
                            } catch (IllegalArgumentException error) {
                                System.out.println("Máximo de membros já atribuido à tarefa.");
                                break;
                            }
                            System.out.println("Tarefa '" + searchedTask + "' atribuída a '" + searchedUser + "'.");
                            break;
                        } else {
                            System.out.println("Usuário não encontrado.");
                            break;
                        }
                    } else {
                        System.out.println("Tarefa não encontrada.");
                        break;
                    }

                case 8:
                    System.out.println("Remover usuário de tarefa");
                    System.out.println("Digite o nome da tarefa:");

                    searchedTask = Task.searchTask(input.next(), taskList);

                    if (searchedTask != null) {
                        System.out.println("Digite o nome do usuário:");

                        searchedUser = User.searchUser(input.next(), userList);

                        if (searchedUser != null) {
                            searchedUser.removeTask(searchedTask);
                            System.out.println("Tarefa '" + searchedTask + "' removida de '" + searchedUser + "'.");
                            break;
                        } else {
                            System.out.println("Usuário não encontrado.");
                            break;
                        }
                    } else {
                        System.out.println("Tarefa não encontrada.");
                        break;
                    }

                case 9:
                    System.out.println("Fechando programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}