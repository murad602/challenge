package backend.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Task")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Task {
    @Id
    @Column(name = "title")
    private String title;
    private String description;
    private String deadline;
    private String status;

    public Task(String title, String description, String deadline, String status) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    @ManyToMany()
    @JoinTable(
            name = "users_tasks",
            joinColumns = @JoinColumn(name = "title"),
            inverseJoinColumns = @JoinColumn(name = "user_email"))
    private List<User>tasksUsers;

    public List<User> getTasksUsers() {
        return tasksUsers;
    }

    public void setTasksUsers(List<User> tasksUsers) {
        this.tasksUsers = tasksUsers;
    }
}
