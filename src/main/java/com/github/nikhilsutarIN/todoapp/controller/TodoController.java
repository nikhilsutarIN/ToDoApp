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

            model.addAttribute("todos", todos);

//            model.addAttribute("firstname", user.getFirstname());
//            model.addAttribute("lastname", user.getLastname());

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
    public String toggleTask(@PathVariable int id, Principal p) {

        String email = userService.findUserByEmail(p.getName()).getEmail();
        Integer user_id = userService.getUserIdByEmail(email);
        Integer task_user_id = todoService.getUserIdByTaskId(id);

        if(user_id != null && user_id.equals(task_user_id)) {
            todoService.toggleTask(id);
        }

        return "redirect:/app/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable int id, Principal p) {

//        todoService.deleteTask(id);

        String email = userService.findUserByEmail(p.getName()).getEmail();
        Integer user_id = userService.getUserIdByEmail(email);
        Integer task_user_id = todoService.getUserIdByTaskId(id);

        if(user_id != null && user_id.equals(task_user_id)) {
            todoService.deleteTask(id, email);
        }

        return "redirect:/app/";
    }

}
