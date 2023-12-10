package com.project_management.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController 
{
    
    @Autowired
    private TaskRepository tsRepo;


    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id)
    {
        return tsRepo.findById(id).get();
    }

    @GetMapping("/all")
    public List<Task> getTasks()
    {
        return tsRepo.findAll();
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task t)
    {
        return tsRepo.save(t);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task t, @PathVariable Long id)
    {
        Task existingTask = tsRepo.findById(id).get();
        
        existingTask.setTitle(t.getTitle());
        existingTask.setDescription(t.getDescription());
        existingTask.setAssigneeIds(t.getAssigneeIds());
        existingTask.setPriority(t.getPriority());
        // if priority == super improtant -> notify assigneeIds
        existingTask.setDueToTime(t.getDueToTime());
        existingTask.setState(t.getState());
        
        tsRepo.save(existingTask);


        return existingTask;
    }


    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id)
    {
        try {
            tsRepo.deleteById(id);
            return "Task successfully deleted";
        } catch (Exception e) {
            return "Task not found";
        }
    }
    

}
