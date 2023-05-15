package com.example.taskmanager41.classes;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager {

    private static ArrayList<Task> tasks = new ArrayList<>();

    private static Long id = 5L;

    static {
        tasks.add(new Task(1L, "Complete Task From Spring boot", "2023-05-13", true));
        tasks.add(new Task(2L, "English Home Task", "2023-05-23", true));
        tasks.add(new Task(3L, "Complete Task From Spring boot", "2023-06-21", true));
        tasks.add(new Task(4L, "Final Spring Project", "2023-05-31", false));
    }

    public static ArrayList<Task> getTasks(){
        return tasks;
    }

    public static void addTask(Task task){
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTask(Long id){
        for(Task it : tasks){
            if(it.getId() == id){
                return it;
            }
        }
        return null;
    }
    public static void deleteTask(Long id){
        for(int i = 0;i<tasks.size();i++){
            if (tasks.get(i).getId() == id){
                tasks.remove(i);
            }
        }
    }
}
