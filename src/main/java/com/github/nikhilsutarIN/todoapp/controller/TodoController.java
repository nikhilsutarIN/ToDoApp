package com.github.nikhilsutarIN.todoapp.controller;

import com.github.nikhilsutarIN.todoapp.entity.Todo;
import com.github.nikhilsutarIN.todoapp.entity.User;
import com.github.nikhilsutarIN.todoapp.service.TodoService;
import com.github.nikhilsutarIN.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getTasks(Model model, Principal p) {
        User user = userService.findUserByEmail(p.getName());

        if(user != null) {
            List<Todo> todos = todoService.getTasksById(user.getId());

            // New tasks appear on top
            List<Todo> reverseTodo = new ArrayList<>();
            for(int i = todos.size() - 1; i >= 0; i--) {
                reverseTodo.add(todos.get(i));
            }

            model.addAttribute("todos", reverseTodo);

            return "app";
        }
        return "redirect:/signin";

    }

    @PostMapping("/")
    public String addTask(@RequestParam String title, @RequestParam String description, Principal p) {
        String email = userService.findUserByEmail(p.getName()).getEmail();

        todoService.addTask(title, description, email);

        return "redirect:/app/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable String id, Principal p) {
        if(id != null) {
            todoService.toggleTask(id, p.getName());
        }

        return "redirect:/app/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable String id, Principal p) {
        if(id != null) {
            todoService.deleteTask(id, p.getName());
        }

        return "redirect:/app/";
    }

}
