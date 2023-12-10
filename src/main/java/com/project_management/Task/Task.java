package com.project_management.Task;

import java.sql.Timestamp;
import java.sql.Time;
import java.util.UUID;

import jakarta.persistence.*;

enum TaskState {
    ASSIGNED,
    IN_PROGRESS,
    ASSIGNED_FOR_REVIEW,
    REVIEWING,
    COMPLETED,
}

@Entity @Table(name = "tasks")
public class Task {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskId;

    @Column(name = "title")
    private String title;

    @Column(name = "descriptiom")
    private String description;

    @Column(name = "assignee_ids")
    private int[] assigneeIds;

    @Column(name = "due_to_date")
    private Time dueToDate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "priority")
    // maximum - 5 (most important)
    // minimum - 1 (less important)
    private int priority;

    @Column(name = "image")
    // optional card decorations
    private byte image;

    @Column(name = "state")
    private TaskState state;

    Task(
        String title, 
        String description, 
        int[] assigneeIds, 
        Time dueToDate, 
        Time createdAt, 
        int priority) 
    {
        this.title = 
            title;
        
        this.taskId = UUID.
            randomUUID().
            toString();

        this.description = 
            description;
        this.assigneeIds = 
            assigneeIds;
        this.dueToDate = 
            dueToDate;
        this.createdAt = 
            new Timestamp(System.currentTimeMillis());
        this.state = 
            TaskState.ASSIGNED;

        this.priority = 
            priority; 
    }

    Task(Task t) 
    {
        this.title = 
            t.getTitle();
        
        this.taskId = UUID.
            randomUUID().
            toString();

        this.description = 
            t.getDescription();
        this.assigneeIds = 
            t.getAssigneeIds();
        this.dueToDate = 
            t.getDueToTime();
        this.createdAt = 
            new Timestamp(System.currentTimeMillis());
        this.state = 
            TaskState.ASSIGNED;

        this.priority = 
            t.getPriority(); 
    }


    // getter and setter methods for fields
    public Long getId() 
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTaskId()
    {
        return this.taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int[] getAssigneeIds()
    {
        return this.assigneeIds;
    }

    public void setAssigneeIds(int[] assigneeIds)
    {
        this.assigneeIds = assigneeIds;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priotity) 
    {
        this.priority = priotity;
    }

    public Time getDueToTime()
    {
        return this.dueToDate;
    }

    public void setDueToTime(Time dueToTime)
    {
        this.dueToDate = dueToTime;
    }

    public Time getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Time createdAt)
    {
        this.createdAt = createdAt;
    }

    public TaskState getState()
    {
        return this.state;
    }

    public void setState(TaskState t)
    {
        this.state = t;
    }


    // methods for task:
    // 1. update change priority (priority can change anoyone assigned to task, or admin + notification)
    // 2. finish (move to completed_tasks table, and delete from table "tasks")
    // 3. add assignees (add notify them)


    // add comments at each stage
    // and when task is finished - generate a "report"


}
