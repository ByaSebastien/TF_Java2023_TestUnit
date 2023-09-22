package be.bstorm;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        return tasks.add(task);
    }

    public boolean removeTask(String description) {
        Task task = findTaskByDescription(description);
        if (task != null) {
            return tasks.remove(task);
        }
        return false;
    }

    public boolean markTaskAsCompleted(String description){
        Task task = findTaskByDescription(description);
        if(task != null){
            task.markAsCompleted();
            return true;
        }
        return false;
    }

    public List<Task> getPendingTasks(){
//        List<Task> pendingTasks = new ArrayList<>();
//        for(Task task : tasks){
//            if(!task.isCompleted()){
//                pendingTasks.add(task);
//            }
//        }
//        return pendingTasks;
        return tasks.stream().filter(t -> !t.isCompleted()).toList();
    }

    public List<Task> getCompletedTasks(){
//        List<Task> completedTasks = new ArrayList<>();
//        for(Task task : tasks){
//            if(task.isCompleted()){
//                completedTasks.add(task);
//            }
//        }
//        return pendingTasks;
        return tasks.stream().filter(Task::isCompleted).toList();
    }

    public Task findTaskByDescription(String description) {
//        for (Task task : tasks) {
//            if (task.getDescription().equals(description)) {
//                return task;
//            }
//        }
//        return null;
        return tasks.stream().filter(t -> t.getDescription().equals(description)).findFirst().orElse(null);
    }
}
