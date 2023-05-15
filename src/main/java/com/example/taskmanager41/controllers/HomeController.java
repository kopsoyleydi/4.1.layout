package com.example.taskmanager41.controllers;

import com.example.taskmanager41.classes.DBManager;
import com.example.taskmanager41.classes.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String main(Model model){
        ArrayList<Task> tasks = DBManager.getTasks();
        model.addAttribute("tasks", tasks);
        return "main";
    }

    @PostMapping(value = "/addTask")
    public String addTask(Task task){
        DBManager.addTask(task);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id){
        Task task = DBManager.getTask(id);
        model.addAttribute("item", task);
        return "detail";
    }

    @GetMapping(value = "add")
    public String add(){
        return "addTask";
    }

    @PostMapping(value = "saveTask")
    public String save(@RequestParam(name = "name", defaultValue = "No Item") String name,
                       @RequestParam(name = "deadLine", defaultValue = "0") String deadLine,
                       @RequestParam(name = "isCompleted", defaultValue = "0") boolean isCompleted,
                       @RequestParam(name = "id") Long id){
        Task task1 = DBManager.getTask(id);
        task1.setName(name);
        task1.setCompleted(isCompleted);
        task1.setDeadLine(deadLine);
        return "redirect:/";
    }
    @PostMapping(value = "delete")
    public String delete(@RequestParam(name = "del_id") Long id){
        DBManager.deleteTask(id);
        return "redirect:/";
    }
}
