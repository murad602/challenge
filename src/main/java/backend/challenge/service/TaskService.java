package backend.challenge.service;

import backend.challenge.entity.Task;
import backend.challenge.entity.User;
import backend.challenge.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public void addTask(Task task){

        taskRepository.save(task);
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
}
