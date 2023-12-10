package com.project_management.User;

import jakarta.persistence.*;
import com.project_management.Task.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

enum UserRole {
    ADMIN,
    USER
}

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private UserRole role;

    @Column(name = "assigned_tasks")
    private ArrayList<Task> assignedTasks;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "tasks_completed")
    private int tasksCompleted;

    @Column(name = "tasks_assigned")
    private int tasksAssigned;

    @Column(name = "average_task_complete_time")
    private int averageTaskCompleteTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public ArrayList<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(ArrayList<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public int getTasksAssigned() {
        return tasksAssigned;
    }

    public void setTasksAssigned(int tasksAssigned) {
        this.tasksAssigned = tasksAssigned;
    }

    public int getAverageTaskCompleteTime() {
        return averageTaskCompleteTime;
    }

    public void setAverageTaskCompleteTime(int averageTaskCompleteTime) {
        this.averageTaskCompleteTime = averageTaskCompleteTime;
    }

    // Constructor remains unchanged
    User(String firstname, String lastname, String email, String password, UserRole role, Time createdAt) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.assignedTasks = new ArrayList<Task>();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
